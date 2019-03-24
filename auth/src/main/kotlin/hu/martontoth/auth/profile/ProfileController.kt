package hu.martontoth.auth.profile

import hu.martontoth.auth.security.NotflixUserDetails
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("profile")
class ProfileController(
        private val profileService: ProfileService
) {

    @GetMapping
    fun profile(@AuthenticationPrincipal principal: NotflixUserDetails) =
            profileService.getProfile(principal.id)
}
