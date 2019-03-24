package hu.martontoth.metadata.external

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
        name = "AuthServiceClient",
        url = "\${auth.url}",
        configuration = [FeignConfiguration::class]
)
interface AuthServiceClient {

    @GetMapping("/api/profile")
    fun getProfile(): Profile

}
