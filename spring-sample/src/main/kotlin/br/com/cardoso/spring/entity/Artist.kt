package br.com.cardoso.spring.entity

import javax.persistence.*

@Entity
@Table(name = "artists")
class Artist(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String
)