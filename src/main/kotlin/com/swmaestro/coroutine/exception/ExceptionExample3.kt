import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import mu.KotlinLogging

private val log = KotlinLogging.logger { }

fun main(): Unit = runBlocking {
    supervisorScope {
        launch {
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
    }
    log.info { "DONE" }
}