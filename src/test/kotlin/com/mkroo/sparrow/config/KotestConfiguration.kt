package com.mkroo.sparrow.config

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.extensions.spring.SpringAutowireConstructorExtension
import org.springframework.test.context.ActiveProfiles

@ActiveProfiles("test")
class KotestConfiguration : AbstractProjectConfig() {
    override val parallelism = 3
    override fun extensions() = listOf(SpringAutowireConstructorExtension)
}
