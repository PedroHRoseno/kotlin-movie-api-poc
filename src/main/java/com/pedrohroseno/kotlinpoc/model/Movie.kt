package com.pedrohroseno.kotlinpoc.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Movie(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null, val title: String? = null, val genre: String? = null, val director: String? = null, val actors: String? = null, var rating: String? = null){
}