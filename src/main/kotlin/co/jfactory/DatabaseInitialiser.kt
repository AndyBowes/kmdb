package co.jfactory

import co.jfactory.repository.MovieRepository
import co.jfactory.util.CsvParser
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class DatabaseInitializer(val movieRepository: MovieRepository) {

    @PostConstruct
    fun init() {
        movieRepository.deleteAll()
        if (movieRepository.count() == 0L){
            CsvParser.readMovies().forEach {
                movieRepository.save(it)
            }
        }
    }
}