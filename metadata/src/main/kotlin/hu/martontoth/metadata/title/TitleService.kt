package hu.martontoth.metadata.title

import hu.martontoth.metadata.external.AuthServiceClient
import hu.martontoth.metadata.title.dto.SaveTitleDto
import hu.martontoth.metadata.title.dto.TitleDto
import hu.martontoth.metadata.title.dto.TitleDtoWithProgress
import hu.martontoth.metadata.unwrap
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class TitleService(
        val movieRepository: TitleRepository,
        val authServiceClient: AuthServiceClient
) {

    fun getAllTitlesForUser(userId: Long): List<TitleDtoWithProgress> {
        val profile = authServiceClient.getProfile()
        return getAllTitles()
                .map { title ->
                    TitleDtoWithProgress(
                            id = title.id,
                            title = title.title,
                            description = title.description,
                            length = title.length,
                            progress = profile.contentProgresses.find { it.titleId == title.id }?.progress ?: 0L,
                            watched = profile.contentProgresses.find { it.titleId == title.id }?.watched ?: false
                    )
                }
    }

    fun getTitleForUser(titleId: Long, userId: Long): TitleDtoWithProgress? {
        val profile = authServiceClient.getProfile()
        return movieRepository.findById(titleId).unwrap()?.let { title ->
            TitleDtoWithProgress(
                    id = title.id!!,
                    title = title.title,
                    description = title.description,
                    length = title.length,
                    progress = profile.contentProgresses.find { it.titleId == title.id }?.progress ?: 0,
                    watched = profile.contentProgresses.find { it.titleId == title.id }?.watched ?: false
            )
        }
    }

    fun getAllTitles(): List<TitleDto> =
            movieRepository.findAll(Sort.by("id"))
                    .map { titleEntityToGetTitleDto(it) }

    fun saveMovie(saveMovieDto: SaveTitleDto): TitleDto =
            movieRepository.save(TitleEntity(
                    id = null,
                    title = saveMovieDto.title,
                    description = saveMovieDto.description,
                    length = saveMovieDto.length
            )).let { titleEntityToGetTitleDto(it) }


    fun titleEntityToGetTitleDto(entity: TitleEntity): TitleDto =
            TitleDto(
                    id = entity.id!!,
                    title = entity.title,
                    description = entity.description,
                    length = entity.length
            )

}
