package hu.martontoth.auth.user


data class UserTitleProgress(
        val userId: Long,
        val titleId: Long,
        val progress: Long,
        val watched: Boolean
)

data class User(
        val id: Long,
        val username: String
)
