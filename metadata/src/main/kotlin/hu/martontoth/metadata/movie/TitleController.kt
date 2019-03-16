package hu.martontoth.metadata.movie

import hu.martontoth.metadata.movie.dto.GetTitleDto
import hu.martontoth.metadata.movie.dto.SaveTitleDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("titles")
class TitleController(
        private val titleService: TitleService
) {

    @GetMapping
    fun getMovies(): List<GetTitleDto> =
            titleService.getAllMovies()

    @PostMapping
    fun saveMovie(@RequestBody saveMovieDto: SaveTitleDto) =
            titleService.saveMovie(saveMovieDto)

}
