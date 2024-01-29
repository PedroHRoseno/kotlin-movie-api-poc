package com.pedrohroseno.kotlinpoc.response

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

data class OmdbResponse (

    @JsonProperty("Title")var title: String? = null,
    @JsonProperty("Year")var year: String?= null,
    @JsonProperty("Rated")var rated: String?= null,
    @JsonProperty("Released")var released: String?= null,
    @JsonProperty("Runtime")var runtime: String?= null,
    @JsonProperty("Genre")var genre: String?= null,
    @JsonProperty("Director")var director: String?= null,
    @JsonProperty("Writer")var writer: String?= null,
    @JsonProperty("Actors")var actors: String?= null,
    @JsonProperty("Plot")var plot: String?= null,
    @JsonProperty("Language")var language: String?= null,
    @JsonProperty("Country")var country: String?= null,
    @JsonProperty("Awards")var awards: String?= null,
    @JsonProperty("Poster")var poster: String?= null,
    @JsonProperty("Ratings") @OneToOne var ratings: ArrayList<Ratings>? = arrayListOf(),
    @JsonProperty("Metascore")var metascore: String?= null,
    @JsonProperty("imdbRating")var imdbRating: String?= null,
    @JsonProperty("imdbVotes")var imdbVotes: String?= null,
    @JsonProperty("imdbID")var imdbID: String?= null,
    @JsonProperty("Type")var type: String?= null,
    @JsonProperty("totalSeasons")var totalSeasons : String?= null,
    @JsonProperty("Response")var response: String?= null

)

data class Ratings (
    var source: String? = null,
    var value: String? = null
)