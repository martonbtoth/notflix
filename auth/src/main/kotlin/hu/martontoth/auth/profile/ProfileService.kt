package hu.martontoth.auth.profile

import hu.martontoth.auth.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProfileService(
        @Autowired
        private val userService: UserService
) {

    fun getProfile(userId: Long): Profile = Profile(
            userId = userId,
            username = userService.findUser(userId)?.username ?: throw RuntimeException("User not found"),
            contentProgresses = userService.getTitleProgressesForUser(userId).map {
                ContentProgress(
                        titleId = it.titleId,
                        progress = it.progress,
                        watched = it.watched
                )
            }
    )


}
