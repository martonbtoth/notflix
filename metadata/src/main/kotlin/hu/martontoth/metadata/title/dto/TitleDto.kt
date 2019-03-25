package hu.martontoth.metadata.title.dto

data class TitleDto(
        val id: Long,
        val title: String,
        val description: String,
        val length: Long
)

data class TitleDtoWithProgress(
        val id: Long,
        val title: String,
        val description: String,
        val length: Long,
        val progress: Long,
        val watched: Boolean
)
