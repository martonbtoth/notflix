package hu.martontoth.auth.login

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/login")
class LoginController(
        @Autowired
        private val loginService: LoginService
) {

    @PostMapping
    fun login(@RequestBody loginRequest: LoginRequest) =
            LoginResponse(
                    token = loginService.login(loginRequest.username, loginRequest.password)
            )

}
