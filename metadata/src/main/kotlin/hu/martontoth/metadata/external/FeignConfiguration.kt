package hu.martontoth.metadata.external

import feign.RequestInterceptor
import hu.martontoth.metadata.context.NotflixContextHolder
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean

class FeignConfiguration {

    private val logger = LoggerFactory.getLogger(FeignConfiguration::class.java)

    @Bean
    fun requestInterceptor(applicationContext: ApplicationContext): RequestInterceptor {
        return RequestInterceptor { requestTemplate ->
            try {
                applicationContext.getBean(NotflixContextHolder::class.java).context
                        .let { context ->
                            requestTemplate.header("Authorization", "Bearer ${context.sessionToken}")
                        }
            } catch (e: Exception) {
                logger.warn("Could not propagate session token", e)
            }
        }
    }

}
