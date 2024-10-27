package com.mkroo.sparrow

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<SparrowApplication>().with(TestcontainersConfiguration::class).run(*args)
}
