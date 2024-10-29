package com.mkroo.sparrow.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import java.time.LocalDateTime

abstract class AbstractTable: Persistable<Long> {
    @Id
    @Column("id")
    private var _id: Long? = null

    val id: Long
        get() = _id ?: throw IllegalStateException("Entity is not persisted yet")

    override fun getId(): Long? {
        return _id
    }

    override fun isNew(): Boolean {
        return _id == null
    }

    @CreatedDate
    var createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    var updatedAt: LocalDateTime = LocalDateTime.now()
}