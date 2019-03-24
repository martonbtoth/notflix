package hu.martontoth.auth.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface UserTitleProgressRepository : JpaRepository<UserTitleProgressEntity, Long> {

    @Query("SELECT u FROM UserTitleProgressEntity u WHERE u.user.id = :userId")
    fun findByUserId(
            @Param("userId") userId: Long
    ): List<UserTitleProgressEntity>

}
