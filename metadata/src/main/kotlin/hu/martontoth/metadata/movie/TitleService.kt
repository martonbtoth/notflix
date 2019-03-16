package hu.martontoth.metadata.movie

import hu.martontoth.metadata.movie.dto.GetTitleDto
import hu.martontoth.metadata.movie.dto.SaveTitleDto
import org.springframework.stereotype.Service

@Service
class TitleService(
        val movieRepository: TitleRepository
) {

    fun getAllMovies(): List<GetTitleDto> =
        movieRepository.findAll()
                .map { movieEntityToGetMovieDto(it) }

    fun saveMovie(saveMovieDto: SaveTitleDto): GetTitleDto =
        movieRepository.save(TitleEntity(
                id = null,
                title = saveMovieDto.title,
                description = saveMovieDto.description
        )).let { movieEntityToGetMovieDto(it) }


    fun movieEntityToGetMovieDto(entity: TitleEntity): GetTitleDto =
            GetTitleDto(
                    id = entity.id!!,
                    title = entity.title,
                    description = entity.description
            )

}