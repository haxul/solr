package cuncerency

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.lang.Exception

suspend fun dowork(i: Int) {
    coroutineScope {
        repeat(2) { i ->
            launch {
                delay(5000)
                println(i)
            }
        }
    }

}


suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}

fun work() = runBlocking {
    val one = async {
        try {
            withTimeout(800) {
                doSomethingUsefulOne()
            }
        } catch (e: Exception) {
            0
        }
    }
    val two = async { doSomethingUsefulTwo() }
    println("The answer is ${one.await() + two.await()}")
}

fun simple(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(1000) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}


suspend fun performRequest(request: Int): String {
    delay(1000) // imitate long-running asynchronous work
    return "response $request"
}

fun main() = runBlocking<Unit> {
    work()
    print("end")
}