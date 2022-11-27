package br.com.cardoso.spring.repository

import br.com.cardoso.spring.entity.Artist
import org.springframework.data.repository.CrudRepository

interface ArtistRepository : CrudRepository<Artist, Long> {

    fun findByNameStartsWith(letter: Char): List<Artist>
}