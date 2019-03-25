package hu.martontoth.content.security

import hu.martontoth.metadata.security.NotflixUserDetails
import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextImpl
import org.springframework.security.web.server.context.ServerSecurityContextRepository
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono


@Component
class NotflixSecurityContextRepository(
        @Value("\${jwt.secret}")
        private val secretKey: String
) : ServerSecurityContextRepository {

    override fun save(exchange: ServerWebExchange?, context: SecurityContext?): Mono<Void> {
        throw UnsupportedOperationException("Not yet supported")
    }

    override fun load(exchange: ServerWebExchange): Mono<SecurityContext> {
        val authHeader = exchange.request.headers.getFirst("Authorization") ?: return Mono.empty()

        val token = authHeader.removePrefix("Bearer ")
        val parsedToken = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)

        val auth = UsernamePasswordAuthenticationToken(
                NotflixUserDetails(
                        id = (parsedToken.body["id"] as Int).toLong(),
                        username = parsedToken.body.subject,
                        password = "",
                        authorities = (parsedToken.body["auth"] as List<String>)
                ), null, (parsedToken.body["auth"] as List<String>).map { SimpleGrantedAuthority(it) }
        )
        return Mono.just(SecurityContextImpl(auth))
    }

}
