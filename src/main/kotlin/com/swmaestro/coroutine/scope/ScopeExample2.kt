import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val log = KotlinLogging.logger { }

fun main(): Unit = runBlocking {
    try {
        coroutineScope {
            launch {
                error("test")
            }
        }
    } catch (e: Exception) {
        log.error(e) { "error handle" }
    }
}