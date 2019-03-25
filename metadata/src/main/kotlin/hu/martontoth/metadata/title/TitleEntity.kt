package hu.martontoth.metadata.title

import javax.persistence.*

@Table(name = "title")
@Entity
class TitleEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        val title: String,
        val description: String,
        val length: Long
)
