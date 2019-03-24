package hu.martontoth.auth.security

import hu.martontoth.auth.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component


@Component
class NotflixUserDetailsService(
        @Autowired
        private val userRepository: UserRepository
) : UserDetailsService {

    // TODO impl
    override fun loadUserByUsername(username: String?): UserDetails {
        if (username == null) {
            throw UsernameNotFoundException("\uD83E\uDD37")
        }

        return userRepository.findByUsername(username)?.let {
            User.withUsername(it.username)
                    .password(it.password)
                    .authorities("USER")
                    .accountExpired(false)
                    .accountLocked(false)
                    .disabled(false)
                    .credentialsExpired(false)
                    .build()
        } ?: throw UsernameNotFoundException("\uD83E\uDD37")
    }

}
