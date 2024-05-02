import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

private val log = KotlinLogging.logger { }

fun main(): Unit = runBlocking {
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