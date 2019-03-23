package hu.martontoth.auth.profile

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("profile")
class ProfileController {

    @GetMapping
    fun profile(@AuthenticationPrincipal principal: String) : ProfileResponse {
        return ProfileResponse(principal)
    }
}
