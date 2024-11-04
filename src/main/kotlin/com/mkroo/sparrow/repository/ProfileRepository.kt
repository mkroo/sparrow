package com.mkroo.sparrow.repository

import com.mkroo.sparrow.domain.AccountId
import com.mkroo.sparrow.domain.Profile
import com.mkroo.sparrow.domain.ProfileId
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface ProfileRepository : ReactiveCrudRepository<Profile, ProfileId> {
    fun findByAccountId(accountId: AccountId): Flux<Profile>
}
