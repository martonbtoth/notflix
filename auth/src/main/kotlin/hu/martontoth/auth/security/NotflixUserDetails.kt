package hu.martontoth.auth.security

import org.springframework.security.core.CredentialsContainer
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails


class NotflixUserDetails(
        val id: Long,
        private val username: String,
        private val password: String,
        private val authorities: List<String>
) : UserDetails, CredentialsContainer {

    override fun eraseCredentials() {}

    override fun getAuthorities(): Collection<GrantedAuthority> = authorities
            .map { SimpleGrantedAuthority(it) }

    override fun isEnabled(): Boolean = true

    override fun getUsername(): String = username

    override fun isCredentialsNonExpired(): Boolean = true

    override fun getPassword(): String = password

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true
}
