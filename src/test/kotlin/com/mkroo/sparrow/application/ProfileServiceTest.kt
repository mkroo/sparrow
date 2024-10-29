package com.mkroo.sparrow.application

import com.mkroo.sparrow.domain.Account
import com.mkroo.sparrow.domain.Profile
import com.mkroo.sparrow.repository.AccountRepository
import com.mkroo.sparrow.repository.ProfileRepository
import com.mkroo.sparrow.utils.FixtureBuilders
import com.navercorp.fixturemonkey.kotlin.setExp
import io.kotest.core.spec.style.DescribeSpec
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import org.springframework.test.context.ActiveProfiles
import reactor.test.StepVerifier

@DataR2dbcTest
@ActiveProfiles("test")
class ProfileServiceTest(
    private val accountRepository: AccountRepository,
    private val profileRepository: ProfileRepository,
) : DescribeSpec({
    val profileService = ProfileService(profileRepository)

    describe("ProfileService#createProfile") {
        lateinit var account: Account

        val profileName = FixtureBuilders.shortString()
        val profileDescription = FixtureBuilders.longString()

        beforeEach {
            accountRepository.save(FixtureBuilders.sample()).subscribe {
                account = it
            }
        }

        it("저장된 계정을 반환한다") {
            val actual = profileService.createProfile(account, profileName, profileDescription)

            StepVerifier.create(actual)
                .expectNextMatches { it.accountId == account.id && it.name == profileName && it.description == profileDescription }
                .verifyComplete()

            StepVerifier.create(profileRepository.findAll())
                .expectNextMatches { it.accountId == account.id && it.name == profileName && it.description == profileDescription }
                .verifyComplete()
        }
    }

    describe("ProfileService#listProfiles") {
        lateinit var account: Account
        lateinit var otherAccount: Account
        lateinit var profiles: List<Profile>

        beforeEach {
            account = accountRepository.save(FixtureBuilders.sample()).block()!!
            otherAccount = accountRepository.save(FixtureBuilders.sample()).block()!!

            val profileBuilder = FixtureBuilders.builder<Profile>().setExp(Profile::accountId, account.id)

            profiles = profileBuilder.sampleList(3)

            profileRepository.saveAll(profiles).collectList().block()

            val otherProfile = FixtureBuilders
                .builder<Profile>()
                .setExp(Profile::accountId, otherAccount.id)
                .sample()
            profileRepository.save(otherProfile).subscribe()
        }

        it("프로필 목록을 반환한다") {
            val actual = profileService.listProfiles(account)

            profiles.listIterator()
            StepVerifier.create(actual)
                .expectNext(profiles[0])
                .expectNext(profiles[1])
                .expectNext(profiles[2])
                .verifyComplete()
        }
    }
})
