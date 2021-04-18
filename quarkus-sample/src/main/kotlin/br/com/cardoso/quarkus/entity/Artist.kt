package br.com.cardoso.quarkus.entity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import javax.persistence.*

@Entity
@Table(name = "artists")
data class Artist(@Id
                  @GeneratedValue(strategy = GenerationType.IDENTITY)
                  var id: Int,
                  var name: String) : PanacheEntityBase {

    companion object : PanacheCompanion<Artist> {
        fun findByNameStartsWith(letter: String) = list("name LIKE '$letter%'")
    }
}