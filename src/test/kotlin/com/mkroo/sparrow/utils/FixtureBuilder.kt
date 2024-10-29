package com.mkroo.sparrow.utils

import com.mkroo.sparrow.domain.Account
import com.mkroo.sparrow.domain.Profile
import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import com.navercorp.fixturemonkey.kotlin.setExp
import net.jqwik.api.Arbitraries

object FixtureBuilders {
    val fixtureMonkey: FixtureMonkey = FixtureMonkey.builder()
        .plugin(KotlinPlugin())
        .register(Account::class.java) {
            it.giveMeBuilder<Account>()
                .setExp(Account::oauthProvider, oauthProviderArbitrary())
                .setExp(Account::oauthId, numericStringArbitrary())
        }
        .register(Profile::class.java) {
            it.giveMeBuilder<Profile>()
                .setExp(Profile::name, shortStringArbitrary())
                .setExp(Profile::description, longStringArbitrary())
        }
        .build()

    inline fun <reified T> builder() = fixtureMonkey.giveMeBuilder<T>()
    inline fun <reified T> sample(): T = builder<T>().sample()

    private fun oauthProviderArbitrary() = Arbitraries.of("google", "facebook", "kakao")
    private fun numericStringArbitrary() = Arbitraries.strings().numeric().ofLength(8)
    private fun shortStringArbitrary() = Arbitraries.strings().alpha().ofLength(12)
    private fun longStringArbitrary() = Arbitraries.strings().alpha().ofLength(128)

    fun shortString() = shortStringArbitrary().sample()
    fun longString() = longStringArbitrary().sample()
}
