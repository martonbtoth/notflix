package hu.martontoth.metadata.movie

import org.springframework.data.jpa.repository.JpaRepository

interface TitleRepository : JpaRepository<TitleEntity, Long>