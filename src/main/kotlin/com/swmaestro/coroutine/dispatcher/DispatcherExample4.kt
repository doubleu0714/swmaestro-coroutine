package com.swmaestro.coroutine.dispatcher

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.util.concurrent.Executors
import kotlin.system.measureTimeMillis

fun main() {
    measureTimeMillis {
        val dispatcher = Executors.newFixedThreadPool(2).asCoroutineDispatcher()
        runBlocking(dispatcher) {
            log.info { "1" }
            launch {
                log.info { "2" }
                delay(1000)
                log.info { "3" }
            }
            launch {
                log.info { "4" }
                delay(1000)
                log.info { "5" }
            }
            log.info { "6" }
        }
    }.also {
        log.info { "elapse time: $it" }
    }
}

private val log = KotlinLogging.logger { }