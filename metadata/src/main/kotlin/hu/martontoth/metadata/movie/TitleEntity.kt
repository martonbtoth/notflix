package hu.martontoth.metadata.movie

import javax.persistence.*

@Table(name = "title")
@Entity
class TitleEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        val title: String,
        val description: String
)