package co.jfactory.model

import org.springframework.data.annotation.Id

data class Movie(@Id val id: String,
                 val title: String,
                 val director: String,
                 val releaseYear: Int?,
                 val actors: List<String>,
                 val genres: List<String>,
                 val keywords: List<String>,
                 val imdbUrl: String)

