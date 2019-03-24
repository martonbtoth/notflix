package hu.martontoth.metadata.security

import hu.martontoth.metadata.context.NotflixContextHolder
import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class JwtTokenFilter(
        @Value("\${jwt.secret}")
        private val secretKey: String,
        @Autowired
        private val notflixContextHolder: NotflixContextHolder
        ) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val token = resolveToken(request)
        if (token != null) {
            notflixContextHolder.context = notflixContextHolder.context.copy(sessionToken = token)
            val parsedToken = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
            val auth = UsernamePasswordAuthenticationToken(
                    NotflixUserDetails(
                            id = (parsedToken.body["id"] as Int).toLong(),
                            username = parsedToken.body.subject,
                            password = "",
                            authorities = (parsedToken.body["auth"] as List<String>)
                    ), null, (parsedToken.body["auth"] as List<String>).map { SimpleGrantedAuthority(it) }
            )
            SecurityContextHolder.getContext().authentication = auth
        } else {
            SecurityContextHolder.clearContext()
            response.sendError(403, "Denied")
            return
        }

        filterChain.doFilter(request, response)
    }


    fun resolveToken(req: HttpServletRequest): String? {
        val bearerToken = req.getHeader("Authorization")
        return if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            bearerToken.removePrefix("Bearer ")
        } else null
    }

}
