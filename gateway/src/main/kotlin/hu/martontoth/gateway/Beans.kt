package hu.martontoth.gateway

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class Beans {

    @Bean
    fun routeLocator(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
                .route("titles")
                { it.path("/api/titles").uri("http://localhost:8080/") }
                .route("content")
                {it.path("/api/content/**").uri("http://localhost:8081/")}
                .build()
    }

}