package br.com.cardoso.micronaut.controller

import br.com.cardoso.micronaut.entity.Artist
import br.com.cardoso.micronaut.service.ArtistService
import io.micronaut.http.annotation.*

@Controller
class ArtistController(private val artistService: ArtistService) {

    @Post("/add")
    fun addArtist(@Body listArtists: List<Artist>) = artistService.addArtists(listArtists)

    @Get("/search/{letter}")
    fun searchArtist(@PathVariable("letter") letter:String) = artistService.searchArtist(letter)
}