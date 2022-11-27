package br.com.cardoso.spring.service.impl

import br.com.cardoso.spring.entity.Artist
import br.com.cardoso.spring.repository.ArtistRepository
import br.com.cardoso.spring.service.ArtistService
import org.springframework.stereotype.Service

@Service
class ArtistServiceImpl(private val artistRepository: ArtistRepository) : ArtistService {

    override fun addArtists(listArtists: List<Artist>) {
        artistRepository.saveAll(listArtists)
    }

    override fun searchArtist(letter: Char) = artistRepository.findByNameStartsWith(letter)
}