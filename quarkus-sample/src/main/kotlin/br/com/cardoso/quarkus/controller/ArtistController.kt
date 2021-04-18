package br.com.cardoso.quarkus.controller

import br.com.cardoso.quarkus.entity.Artist
import br.com.cardoso.quarkus.service.ArtistService
import javax.transaction.Transactional
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam

@Path("")
class ArtistController(private val artistService: ArtistService) {

    @POST
    @Path("/add")
    @Transactional
    fun addArtist(listArtists: List<Artist>) = artistService.addArtists(listArtists)

    @GET
    @Path("/search/{letter}")
    fun searchArtist(@PathParam("letter") letter: String) =
            artistService.searchArtist(letter)
}