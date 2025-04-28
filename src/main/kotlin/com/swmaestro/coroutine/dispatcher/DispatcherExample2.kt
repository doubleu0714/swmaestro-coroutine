package com.swmaestro.coroutine.dispatcher

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

fun main() {
    measureTimeMillis {
        val dispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
        runBlocking(dispatcher) {
            repeat(5) {
                launch {
                    log.info { "call suspend method" }
                    delay(1000)
                }
            }
        }
    }.also {
        log.info { "elapse time: $it" }
    }
}

private val log = KotlinLogging.logger { }