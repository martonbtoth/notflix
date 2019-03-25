package hu.martontoth.auth.user

import javax.persistence.*


@Table(name = "user_title_progress")
@Entity
data class UserTitleProgressEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        @Column(name = "title_id")
        val titleId: Long,
        @ManyToOne
        @JoinColumn(name = "user_id")
        val user: UserEntity,
        val progress: Long,
        val watched: Boolean
)
