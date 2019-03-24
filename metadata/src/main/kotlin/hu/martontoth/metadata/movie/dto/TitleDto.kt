package hu.martontoth.metadata.movie.dto

data class TitleDto(
        val id: Long,
        val title: String,
        val description: String
)

data class TitleDtoWithProgress(
        val id: Long,
        val title: String,
        val description: String,
        val progress: Long,
        val watched: Boolean
)
