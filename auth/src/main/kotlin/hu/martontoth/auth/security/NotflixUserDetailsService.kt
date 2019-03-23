package hu.martontoth.auth.security

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component


@Component
class NotflixUserDetailsService : UserDetailsService {

    // TODO impl
    override fun loadUserByUsername(username: String?): UserDetails {
        return if (username == "totlol") {
            User.withUsername(username)
                    .password("\$2a\$10\$btBXUnl/QeqxQuWlLzFkHeKJFbJz.dejMMqtMEhj0tLl4VzX6agYK")
                    .authorities("USER")
                    .accountExpired(false)
                    .accountLocked(false)
                    .disabled(false)
                    .credentialsExpired(false)
                    .build()
        } else {
            throw UsernameNotFoundException("\uD83E\uDD37")
        }
    }

}
