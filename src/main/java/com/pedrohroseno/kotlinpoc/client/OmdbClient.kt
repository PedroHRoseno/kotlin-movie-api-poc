package com.pedrohroseno.kotlinpoc.client

import com.pedrohroseno.kotlinpoc.response.OmdbResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "omdbApi", url = "\${omdb.client.url}")
interface OmdbClient {

    @GetMapping
    fun findMovieByTitle(@RequestParam t: String, @RequestParam apiKey: String): OmdbResponse
}