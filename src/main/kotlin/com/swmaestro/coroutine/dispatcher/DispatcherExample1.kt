package com.swmaestro.coroutine.dispatcher

import mu.KotlinLogging
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

fun main() {
    measureTimeMillis {
        repeat(5) {
            log.info { "call thread blocking" }
            TimeUnit.SECONDS.sleep(1)
        }
    }.also {
        log.info { "elapse time: $it" }
    }
}

private val log = KotlinLogging.logger { }