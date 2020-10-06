package cuncerency

import kotlinx.coroutines.channels.Channel


class Consumer(val channel: Channel<Int>) {
    suspend fun consumer() {
        for (r in channel) {
            println(r)
        }
    }
}