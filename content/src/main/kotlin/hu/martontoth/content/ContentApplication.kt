package hu.martontoth.content

import hu.martontoth.content.security.NotflixSecurityContextRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@SpringBootApplication
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity(proxyTargetClass = true)
class ContentApplication(
        @Autowired
        private val securityContextRepository: NotflixSecurityContextRepository
) {
    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http.csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .securityContextRepository(securityContextRepository)
                .authorizeExchange()
                .anyExchange().permitAll()
                .and().build()

    }
}

fun main(args: Array<String>) {
	runApplication<ContentApplication>(*args)
}
