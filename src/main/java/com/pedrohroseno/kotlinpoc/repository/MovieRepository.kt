package com.pedrohroseno.kotlinpoc.repository

import com.pedrohroseno.kotlinpoc.model.Movie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository: JpaRepository<Movie, Long> {

    override fun findAll(): MutableList<Movie>
}