package hu.martontoth.metadata.external


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
