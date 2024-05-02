import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val log = KotlinLogging.logger { }

fun main(): Unit = runBlocking {
    launch {
        launch {
            delay(1000)
            error("Error")
        }
        launch {
            delay(2000)
            log.info { "A" }
        }
        launch {
            delay(500)
            log.info { "B" }
        }
    }
    launch {
        delay(2000)
        log.info { "C" }
    }
}