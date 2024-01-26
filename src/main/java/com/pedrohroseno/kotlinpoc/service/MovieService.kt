package com.pedrohroseno.kotlinpoc.service

import com.pedrohroseno.kotlinpoc.client.OmdbClient
import com.pedrohroseno.kotlinpoc.model.Movie
import com.pedrohroseno.kotlinpoc.repository.MovieRepository
import com.pedrohroseno.kotlinpoc.response.OmdbResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.springframework.stereotype.Service
import kotlinx.coroutines.runBlocking

@Service
class MovieService(

    private val omdbClient: OmdbClient,
    private val movieRepository: MovieRepository
    ) {

    fun getAllMovies(): MutableList<Movie> = runBlocking{
        movieRepository.findAll()
    }

    fun searchAndAddMovie(movieTitle: String)= runBlocking{
        launch {
            delay(2000)
            val movie = omdbClient.findMovieByTitle(movieTitle,  "9ffb194a")
            println(movie)
        }

        println("Iniciando busca por filme...")
    }

}