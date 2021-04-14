package br.com.cardoso.spring.service

import br.com.cardoso.spring.entity.Artist

interface ArtistService {

    fun addArtists(listArtists: List<Artist>)
    fun searchArtist(letter: Char): List<Artist>
}