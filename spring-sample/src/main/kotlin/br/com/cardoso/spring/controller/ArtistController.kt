package br.com.cardoso.spring.controller

import br.com.cardoso.spring.entity.Artist
import br.com.cardoso.spring.service.ArtistService
import org.springframework.web.bind.annotation.*

@RestController
class ArtistController(private val artistService: ArtistService) {

    @PostMapping("/add")
    fun addArtist(@RequestBody listArtists: List<Artist>) = artistService.addArtists(listArtists)

    @GetMapping("/search/{letter}")
    fun searchArtist(@PathVariable("letter") letter:Char) = artistService.searchArtist(letter)
}