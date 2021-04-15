package br.com.cardoso.micronaut.repository

import br.com.cardoso.micronaut.entity.Artist
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface ArtistRepository : CrudRepository<Artist, Long> {

    fun findByNameStartsWith(letter: String): List<Artist>
}