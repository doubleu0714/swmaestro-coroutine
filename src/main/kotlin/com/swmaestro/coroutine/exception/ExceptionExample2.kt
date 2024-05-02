import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import mu.KotlinLogging

private val log = KotlinLogging.logger { }

fun main(): Unit = runBlocking {
    val job = SupervisorJob()
    launch(job) {
        delay(1000)
        error("Error")
    }
    launch(job) {
        delay(2000)
        log.info { "will be printed" }
    }
    launch(job) {
        delay(500)
        log.info { "will be printed" }
    }
    job.join()
}