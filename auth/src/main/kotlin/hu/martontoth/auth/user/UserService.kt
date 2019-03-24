package hu.martontoth.auth.user

import hu.martontoth.auth.unwrap
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(
        @Autowired
        private val userRepository: UserRepository,
        @Autowired
        private val userTitleProgressRepository: UserTitleProgressRepository
) {

    fun getTitleProgressesForUser(userId: Long): List<UserTitleProgress> =
            userTitleProgressRepository.findByUserId(userId)
                    .map {
                        UserTitleProgress(
                                userId = userId,
                                titleId = it.titleId,
                                progress = it.progress,
                                watched = it.watched
                        )
                    }

    fun findUser(userId: Long): User? =
            userRepository.findById(userId).unwrap()?.let {
                User(
                        id = it.id!!,
                        username = it.username
                )
            }
}
