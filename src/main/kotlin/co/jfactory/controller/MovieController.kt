package co.jfactory.controller

import co.jfactory.repository.MovieRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/movies")
class MovieController {

    @Autowired
    lateinit var movieRespository : MovieRepository

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String) = movieRespository.findById(id).get()

    @GetMapping("/title/{title}")
    fun findByTitle(@PathVariable title: String) = movieRespository.findByTitleLike(title)

    @GetMapping("/director/{director}")
    fun findByDirector(@PathVariable director: String) = movieRespository.findByDirector(director)

    @GetMapping("/actor/{actorName}")
    fun findByActor(@PathVariable actorName: String) = movieRespository.findByActors(actorName)

    @GetMapping("/genre/{genre}")
    fun findByGenre(@PathVariable genre: String) = movieRespository.findByGenres(genre)

    @GetMapping("/keyword/{keyword}")
    fun findByKeyword(@PathVariable keyword: String) = movieRespository.findByKeywords(keyword)

}