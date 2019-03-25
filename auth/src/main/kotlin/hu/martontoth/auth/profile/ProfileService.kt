package hu.martontoth.auth.profile

import hu.martontoth.auth.user.UserService
import hu.martontoth.auth.user.UserTitleProgress
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
            contentProgresses = userService.getTitleProgressesForUser(userId).map { map(it) }
    )

    fun setContentProgress(userId: Long, titleId: Long, progress: Long): ContentProgress =
            map(userService.setTitleProgressForUser(userId, titleId, progress))

    private fun map(userTitleProgress: UserTitleProgress): ContentProgress =
            ContentProgress(
                    titleId = userTitleProgress.titleId,
                    progress = userTitleProgress.progress,
                    watched = userTitleProgress.watched
            )
}
