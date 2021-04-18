package br.com.cardoso.quarkus.service

import br.com.cardoso.quarkus.entity.Artist

interface ArtistService {

    fun addArtists(listArtists: List<Artist>)
    fun searchArtist(letter: String): List<Artist>
}