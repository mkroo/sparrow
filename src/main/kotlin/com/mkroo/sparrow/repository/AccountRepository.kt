package com.mkroo.sparrow.repository

import com.mkroo.sparrow.domain.Account
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AccountRepository : ReactiveCrudRepository<Account, Long> {

}
