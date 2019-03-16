package hu.martontoth.metadata.movie.dto

data class GetTitleDto (
        val id: Long,
        val title: String,
        val description: String
)