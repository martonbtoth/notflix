package hu.martontoth.metadata.title

import org.springframework.data.jpa.repository.JpaRepository

interface TitleRepository : JpaRepository<TitleEntity, Long>
