package hu.martontoth.metadata.title

import hu.martontoth.metadata.security.NotflixUserDetails
import hu.martontoth.metadata.title.dto.SaveTitleDto
import hu.martontoth.metadata.title.dto.TitleDtoWithProgress
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("titles")
class TitleController(
        private val titleService: TitleService
) {

    @GetMapping
    fun getMovies(@AuthenticationPrincipal principal: NotflixUserDetails): List<TitleDtoWithProgress> =
            titleService.getAllTitlesForUser(principal.id)

    @GetMapping("{id}")
    fun getMovies(@PathVariable("id") id: Long,
                  @AuthenticationPrincipal principal: NotflixUserDetails
    ): TitleDtoWithProgress? =
            titleService.getTitleForUser(id, principal.id)

    @PostMapping
    fun saveMovie(@RequestBody saveMovieDto: SaveTitleDto) =
            titleService.saveMovie(saveMovieDto)

}
