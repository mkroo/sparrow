package com.mkroo.sparrow.domain

import org.springframework.data.relational.core.mapping.Table

@Table("message")
data class Message(
    val senderId: ProfileId,
    val channelId: ChannelId,
    val content: String,
) : AbstractTable()
