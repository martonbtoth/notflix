package hu.martontoth.gateway

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class Routes(
        @Value("\${content.uri}")
        private val contentUri: String,
        @Value("\${metadata.uri}")
        private val metadataUri: String,
        @Value("\${auth.uri}")
        private val authUri: String
) {

    @Bean
    fun routeLocator(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
                .route("titles")
                { it.path("/api/titles").uri(metadataUri) }
                .route("content")
                { it.path("/api/content/**").uri(contentUri) }
                .route("auth")
                { it.path("/api/login", "/api/profile", "/api/register").uri(authUri) }
                .build()
    }
}
