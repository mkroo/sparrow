package com.mkroo.sparrow.repository

import com.mkroo.sparrow.domain.Account
import com.mkroo.sparrow.domain.Profile
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface ProfileRepository : ReactiveCrudRepository<Profile, Long> {
    @Query("SELECT * FROM profile WHERE account_id = :account")
    fun findByAccount(account: Account): Flux<Profile>
}
