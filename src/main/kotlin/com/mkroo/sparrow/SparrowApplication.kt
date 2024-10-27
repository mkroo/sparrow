package com.mkroo.sparrow

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SparrowApplication

fun main(args: Array<String>) {
	runApplication<SparrowApplication>(*args)
}
