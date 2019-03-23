package hu.martontoth.auth.login

import hu.martontoth.auth.security.JwtTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Service


@Service
class LoginService(
        @Autowired
        private val authenticationManager: AuthenticationManager,
        @Autowired
        private val jwtTokenProvider: JwtTokenProvider
) {

    fun login(username: String, password: String): String {
        val authentication = authenticationManager.authenticate(UsernamePasswordAuthenticationToken(username, password))
        return jwtTokenProvider.createToken(
                (authentication.principal as User).username,
                authentication.authorities.map { it.authority }
        )
    }

}
