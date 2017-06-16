package co.jfactory.repository

import co.jfactory.model.Movie
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component

@Component
interface MovieRepository : MongoRepository<Movie, String>{

    fun findByTitleLike(title: String) : List<Movie>

    fun findByDirector(director: String) : List<Movie>

    fun findByActors(actor: String) : List<Movie>

    fun findByGenres(genre: String) : List<Movie>

    fun findByKeywords(keyword: String) : List<Movie>
}