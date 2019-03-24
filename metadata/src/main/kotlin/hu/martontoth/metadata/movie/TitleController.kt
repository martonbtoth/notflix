package hu.martontoth.metadata.movie

import hu.martontoth.metadata.movie.dto.SaveTitleDto
import hu.martontoth.metadata.movie.dto.TitleDtoWithProgress
import hu.martontoth.metadata.security.NotflixUserDetails
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("titles")
class TitleController(
        private val titleService: TitleService
) {

    @GetMapping
    fun getMovies(@AuthenticationPrincipal principal: NotflixUserDetails): List<TitleDtoWithProgress> =
            titleService.getAllMoviesForUser(principal.id)


    @PostMapping
    fun saveMovie(@RequestBody saveMovieDto: SaveTitleDto) =
            titleService.saveMovie(saveMovieDto)

}
