package com.mkroo.sparrow.repository

import com.mkroo.sparrow.domain.Account
import com.mkroo.sparrow.domain.AccountId
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AccountRepository : ReactiveCrudRepository<Account, AccountId> {

}
