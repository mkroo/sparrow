package com.mkroo.sparrow.domain

import org.springframework.data.relational.core.mapping.Table

@Table("profile")
data class Profile(
    val accountId: Long,
    val name: String,
    val description: String
) : AbstractTable() {
    constructor(account: Account, name: String, description: String) : this(account.id, name, description)
}
