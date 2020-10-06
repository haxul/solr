package cuncerency

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import java.lang.RuntimeException


class Producer(val channel: Channel<Int>) {
    suspend fun produce() {

        for (i in 1..5) {
            try {
                delay(1000)
                if (i == 4) throw RuntimeException("hahahah")
                channel.send(i)
            } catch (e:Exception) {
                channel.send(0)
            }
        }
        channel.close()
    }
}