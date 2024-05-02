import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import kotlin.coroutines.coroutineContext

private val log = KotlinLogging.logger { }

fun main(): Unit = runBlocking(CoroutineName("swmaestro")) {
    val coroutineName: String? = coroutineContext[CoroutineName]?.name
    launch(CoroutineName("child")) {
        val coroutineName: String? = getCoroutineName()
        delay(1000)
        log.info { "$coroutineName Hello launch world" }
    }
    launch {
        val coroutineName: String? = getCoroutineName()
        delay(1000)
        log.info { "$coroutineName Hello launch world" }
    }
    log.info { "$coroutineName is done" }
}

private suspend fun getCoroutineName(): String? =
    coroutineContext[CoroutineName]?.name