package cuncerency

import kotlinx.coroutines.channels.*
import kotlinx.coroutines.*

import kotlinx.coroutines.runBlocking

fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
    for (x in 1..5) {
        delay(1000)
        send(x * x)
    }
}

suspend fun main(): Unit = runBlocking {
    val channel = Channel<Int>()
    val producer = Producer(channel)
    val consumer = Consumer(channel)
    val handler = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler got $exception")
    }
    launch(handler) {
            producer.produce()
    }
    launch {
            consumer.consumer()

    }

    println("ebd")
}