import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import mu.KotlinLogging

private val log = KotlinLogging.logger { }

suspend fun main(): Unit = coroutineScope {
    val name = CoroutineName("Parent")
    val job = Job()
    launch(name + job) {
        val childName = coroutineContext[CoroutineName]
        log.info { childName == name }
        val childJob = coroutineContext[Job]
        log.info { childJob == job }
        log.info { childJob == job.children.first() }
        log.info { childJob?.parent == job }
    }
}