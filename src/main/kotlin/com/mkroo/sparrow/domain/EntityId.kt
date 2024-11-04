package com.mkroo.sparrow.domain

sealed interface EntityId {
    val value: Long
}

@JvmInline
value class ChannelId(override val value: Long) : EntityId {
    override fun toString(): String {
        return value.toString()
    }
}

@JvmInline
value class ProfileId(override val value: Long) : EntityId {
    override fun toString(): String {
        return value.toString()
    }
}

@JvmInline
value class MessageId(override val value: Long) : EntityId {
    override fun toString(): String {
        return value.toString()
    }
}

@JvmInline
value class AccountId(override val value: Long) : EntityId {
    override fun toString(): String {
        return value.toString()
    }
}
