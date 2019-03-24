package hu.martontoth.auth.user

import javax.persistence.*

@Entity
@Table(name = "\"user\"")
class UserEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        val username: String,
        val password: String
)
