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
                    .map { map(it) }

    fun setTitleProgressForUser(userId: Long, titleId: Long, progress: Long): UserTitleProgress {
        val userTitleProgressEntity = userTitleProgressRepository.findByUserAndTitleId(userId, titleId)?.copy(progress = progress)
                ?: UserTitleProgressEntity(
                        id = null,
                        titleId = titleId,
                        progress = progress,
                        user = userRepository.findById(userId).unwrap()!!,
                        watched = false
                )
        return map(userTitleProgressRepository.save(userTitleProgressEntity))
    }

    fun findUser(userId: Long): User? =
            userRepository.findById(userId).unwrap()?.let {
                User(
                        id = it.id!!,
                        username = it.username
                )
            }

    private fun map(entity: UserTitleProgressEntity): UserTitleProgress =
            UserTitleProgress(
                    userId = entity.user.id!!,
                    titleId = entity.titleId,
                    progress = entity.progress,
                    watched = entity.watched
            )
}
