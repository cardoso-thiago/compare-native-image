package br.com.cardoso.quarkus.service.impl

import br.com.cardoso.quarkus.entity.Artist
import br.com.cardoso.quarkus.service.ArtistService
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ArtistServiceImpl : ArtistService {

    override fun addArtists(listArtists: List<Artist>) {
        Artist.persist(listArtists)
    }

    override fun searchArtist(letter: String) = Artist.findByNameStartsWith(letter)
}