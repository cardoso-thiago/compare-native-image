package br.com.cardoso.micronaut.service.impl

import br.com.cardoso.micronaut.entity.Artist
import br.com.cardoso.micronaut.repository.ArtistRepository
import br.com.cardoso.micronaut.service.ArtistService
import javax.inject.Singleton

@Singleton
class ArtistServiceImpl(private val artistRepository: ArtistRepository) : ArtistService {

    override fun addArtists(listArtists: List<Artist>) {
        artistRepository.saveAll(listArtists)
    }

    override fun searchArtist(letter: String) = artistRepository.findByNameStartsWith(letter)
}