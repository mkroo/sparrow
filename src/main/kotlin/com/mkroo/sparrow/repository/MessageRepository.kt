package com.mkroo.sparrow.repository

import com.mkroo.sparrow.domain.Message
import com.mkroo.sparrow.domain.MessageId
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface MessageRepository : ReactiveCrudRepository<Message, MessageId> {

}
