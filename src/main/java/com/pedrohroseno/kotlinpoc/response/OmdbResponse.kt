package com.pedrohroseno.kotlinpoc.response

data class OmdbResponse (

  var title: String? = null,
  var year: String?= null,
  var rated: String?= null,
  var released: String?= null,
  var runtime: String?= null,
  var genre: String?= null,
  var director: String?= null,
  var writer: String?= null,
  var actors: String?= null,
  var plot: String?= null,
  var language: String?= null,
  var country: String?= null,
  var awards: String?= null,
  var poster: String?= null,
  var ratings: ArrayList<Ratings> = arrayListOf(),
  var metascore: String?= null,
  var imdbRating: String?= null,
  var imdbVotes: String?= null,
  var imdbID: String?= null,
  var type: String?= null,
  var totalSeasons : String?= null,
  var response: String?= null

)

data class Ratings (
  var source: String? = null,
  var value: String? = null
)