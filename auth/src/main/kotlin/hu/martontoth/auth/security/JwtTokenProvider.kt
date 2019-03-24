package hu.martontoth.auth.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest


@Component
class JwtTokenProvider(
        @Value("\${jwt.secret}")
        private val secretKey: String,
        @Value("\${jwt.expiry:21600000}")
        private val expiry: Long
) {

    fun createToken(notflixUserDetails: NotflixUserDetails): String {

        val claims = Jwts.claims().setSubject(notflixUserDetails.username)
        claims["auth"] = notflixUserDetails.authorities.map { it.authority }
        claims["id"] = notflixUserDetails.id

        val now = Date()
        val validity = Date(now.time + expiry)

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact()
    }

    fun getAuthentication(token: String): Authentication {
        val parsedToken = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
        return UsernamePasswordAuthenticationToken(
                NotflixUserDetails(
                        id = (parsedToken.body["id"] as Int).toLong(),
                        username = parsedToken.body.subject,
                        password = "",
                        authorities = (parsedToken.body["auth"] as List<String>)
                ), null, (parsedToken.body["auth"] as List<String>).map { SimpleGrantedAuthority(it) }
        )
    }

    fun resolveToken(req: HttpServletRequest): String? {
        val bearerToken = req.getHeader("Authorization")
        return if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            bearerToken.removePrefix("Bearer ")
        } else null
    }

    fun validateToken(token: String): Boolean {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
            return true
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
