package com.pedrohroseno.kotlinpoc.controller

import com.pedrohroseno.kotlinpoc.model.Movie
import com.pedrohroseno.kotlinpoc.service.MovieService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/movies")
@RestController
class MovieController {

    @Autowired
    lateinit var movieService: MovieService

    @GetMapping
    fun getBooks(): ResponseEntity<Movie> {
        val movie: Movie = movieService.getAllMovies().get(0)
        return ResponseEntity(movie, HttpStatusCode.valueOf(200))
    }

    @PostMapping
    fun addMovie(@RequestParam movieTitle: String){
        movieService.searchAndAddMovie(movieTitle)
    }
}