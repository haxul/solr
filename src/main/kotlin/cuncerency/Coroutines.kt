package cuncerency

import kotlinx.coroutines.*

suspend fun doWork() {
    delay(1000)
    println("work is done")
}


suspend fun main() {
    GlobalScope.launch {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(13000L) // just quit after delay
}