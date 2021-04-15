package br.com.cardoso.micronaut.service

import br.com.cardoso.micronaut.entity.Artist

interface ArtistService {

    fun addArtists(listArtists: List<Artist>)
    fun searchArtist(letter: String): List<Artist>
}