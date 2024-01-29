package com.pedrohroseno.kotlinpoc.controller

import com.pedrohroseno.kotlinpoc.model.Movie
import com.pedrohroseno.kotlinpoc.service.MovieService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/movies")
class MovieController {

    @Autowired
    lateinit var movieService: MovieService

    @GetMapping()
    fun getAllMovie(): ResponseEntity<MutableList<Movie>> {
        return ResponseEntity(movieService.getAllMovies(), HttpStatusCode.valueOf(200))
    }

    @GetMapping(params = ["title"])
    fun getMovieByTitle(@RequestParam title: String): ResponseEntity<Movie?> {
        val movie: Movie? = movieService.getMovie(title)
        return if (movie != null) {
            ResponseEntity(movie, HttpStatus.OK)
        } else {
            ResponseEntity(null, HttpStatus.NOT_FOUND)
        }

    }

    @PostMapping
    fun addMovie(@RequestParam movieTitle: String){
        movieService.searchAndAddMovie(movieTitle)
    }
}