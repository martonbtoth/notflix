package hu.martontoth.auth.profile


data class Profile(
        val userId: Long,
        val username: String,
        val contentProgresses: List<ContentProgress>
)

data class ContentProgress(
        val titleId: Long,
        val progress: Long,
        val watched: Boolean
)

data class SetContentProgressRequest(
        val titleId: Long,
        val progress: Long
)
