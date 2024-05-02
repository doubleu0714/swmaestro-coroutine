import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import mu.KotlinLogging

private val log = KotlinLogging.logger { }

class Custom: CancellationException()

suspend fun main(): Unit = coroutineScope {
    launch {
        launch {
            delay(1000)
            log.info { "will not be printed" }
        }
        throw Custom()
    }
    launch {
        delay(2000)
        log.info { "will be printed" }
    }
    launch {
        delay(500)
        log.info { "will be printed" }
    }
    log.info { "DONE" }
}