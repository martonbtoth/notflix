package hu.martontoth.metadata.movie

import hu.martontoth.metadata.external.AuthServiceClient
import hu.martontoth.metadata.movie.dto.SaveTitleDto
import hu.martontoth.metadata.movie.dto.TitleDto
import hu.martontoth.metadata.movie.dto.TitleDtoWithProgress
import org.springframework.stereotype.Service

@Service
class TitleService(
        val movieRepository: TitleRepository,
        val authServiceClient: AuthServiceClient
) {

    fun getAllMoviesForUser(userId: Long): List<TitleDtoWithProgress> {
        val profile = authServiceClient.getProfile()
        return getAllMovies()
                .map { title ->
                    TitleDtoWithProgress(
                            id = title.id,
                            title = title.title,
                            description = title.description,
                            progress = profile.contentProgresses.find { it.titleId == title.id }?.progress ?: 0L,
                            watched = profile.contentProgresses.find { it.titleId == title.id }?.watched ?: false
                    )
                }
    }

    fun getAllMovies(): List<TitleDto> =
            movieRepository.findAll()
                    .map { movieEntityToGetMovieDto(it) }

    fun saveMovie(saveMovieDto: SaveTitleDto): TitleDto =
            movieRepository.save(TitleEntity(
                    id = null,
                    title = saveMovieDto.title,
                    description = saveMovieDto.description
            )).let { movieEntityToGetMovieDto(it) }


    fun movieEntityToGetMovieDto(entity: TitleEntity): TitleDto =
            TitleDto(
                    id = entity.id!!,
                    title = entity.title,
                    description = entity.description
            )

}
