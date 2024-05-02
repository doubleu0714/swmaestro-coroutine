import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import mu.KotlinLogging

private val log = KotlinLogging.logger { }

suspend fun main(): Unit = supervisorScope {
    val error = async {
        delay(1000)
        error("Error")
    }
    launch {
        delay(2000)
        log.info { "will be printed" }
    }
    launch {
        delay(500)
        log.info { "will be printed" }
    }

    try {
        error.await()
    } catch (e: Exception) {
        log.error(e) { "Error handled" }
    }
    log.info { "DONE" }
}