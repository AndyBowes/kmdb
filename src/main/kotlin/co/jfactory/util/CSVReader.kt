package co.jfactory.util

import co.jfactory.model.Movie
import java.io.InputStreamReader

class CsvParser{
    companion object {
        val imdbUrlPattern = Regex("title/(.*)/.*$").toPattern()

        fun readMovies(): List<Movie>{
            return with(InputStreamReader(CsvParser().javaClass.classLoader.getResourceAsStream("movies.csv"))){
                this.readLines()
                        .drop(1) // Ignore the Header Line
                        .map{ convertLineToMovie(it)}
            }
        }

        private fun convertLineToMovie(line: String) : Movie {
            val tokens = line.split(",")
            val imdbUrl = tokens[17]
            val movieId = extractMovieId(imdbUrl)

            val releaseYear = tokens[23].toIntOrNull()
            val director = tokens[1]
            val actors = listOf(tokens[10],tokens[6],tokens[14])
            val genres = tokens[9].split("|")
            val keywords = tokens[16].split("|")

            return Movie(id= movieId, title = tokens[11],
                    director=director, actors = actors,
                    genres = genres, keywords = keywords,
                    imdbUrl = imdbUrl,
                    releaseYear=releaseYear)
        }

        private fun extractMovieId(imdbUrl: String): String {
            val matcher = imdbUrlPattern.matcher(imdbUrl)
            matcher.find()
            return matcher.group(1)
        }
    }
}
