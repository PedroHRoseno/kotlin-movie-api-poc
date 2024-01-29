package com.pedrohroseno.kotlinpoc.service

import com.pedrohroseno.kotlinpoc.client.OmdbClient
import com.pedrohroseno.kotlinpoc.model.Movie
import com.pedrohroseno.kotlinpoc.repository.MovieRepository
import com.pedrohroseno.kotlinpoc.response.OmdbResponse
import kotlinx.coroutines.launch
import org.springframework.stereotype.Service
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Value

@Service
class MovieService(

    private val omdbClient: OmdbClient,
    private val movieRepository: MovieRepository,
    @Value( "\${omdb.client.apikey}") val apiKey: String
    ) {

    fun getAllMovies(): MutableList<Movie> = runBlocking{
        movieRepository.findAll()
    }

    fun getMovie(title: String): Movie? {
        val movie: Movie = movieRepository.findByTitle(title) ?: return findMovieAndAddToDatabase(title)
        return movie
    }

    fun searchAndAddMovie(movieTitle: String)= runBlocking{
        launch {
            val movie: Movie? = findMovieAndAddToDatabase(movieTitle)
            if (movie == null){
                println("Filme não encontrado")
            }
            println("filme adicionado com sucesso na database")
        }

        println("Iniciando busca por filme...")
    }

    private fun findMovieAndAddToDatabase(movieTitle: String): Movie? {
        val omdbResponse = omdbClient.findMovieByTitle(movieTitle, apiKey)

        val existingMovie = omdbResponse.title?.let { movieRepository.findByTitle(it) }
        if (existingMovie != null) {
            return existingMovie
        }

        if (omdbResponse.response == "True") {
            val newMovie = Movie(
                null, omdbResponse.title, omdbResponse.genre,
                omdbResponse.director, omdbResponse.actors, omdbResponse.imdbRating
            )
            movieRepository.save(newMovie)
            return newMovie
        }

        return null
    }


}