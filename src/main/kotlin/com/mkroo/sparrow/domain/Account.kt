package com.mkroo.sparrow.domain

import org.springframework.data.relational.core.mapping.Table

@Table("account")
data class Account(
    val oauthProvider: String,
    val oauthId: String,
) : AbstractTable()
