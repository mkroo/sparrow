package com.mkroo.sparrow.application

import com.mkroo.sparrow.domain.Account
import com.mkroo.sparrow.domain.AccountId
import com.mkroo.sparrow.domain.Profile
import com.mkroo.sparrow.repository.ProfileRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProfileService(
    private val profileRepository: ProfileRepository,
) {
    fun createProfile(account: Account, name: String, description: String) : Mono<Profile> {
        return Profile(account, name, description).let(profileRepository::save)
    }

    fun listProfiles(account: Account) : Flux<Profile> {
        return profileRepository.findByAccountId(AccountId(account.id))
    }
}
