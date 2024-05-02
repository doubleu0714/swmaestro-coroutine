package com.swmaestro.coroutine.builder

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val log = KotlinLogging.logger { }

fun main(): Unit = runBlocking {
    val job: Job = launch {
        delay(2000)
        log.info { "Hello launch world" }
    }
    val deferred: Deferred<String> = async {
        delay(1000)
        "Hello async worlde"
    }
    val await: String = deferred.await()
    log.info { await }
}