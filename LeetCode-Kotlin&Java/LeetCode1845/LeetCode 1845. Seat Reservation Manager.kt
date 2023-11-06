package 코틀린.LeetCode.LeetCode1845

import java.util.*


class SeatManager(n: Int) {
    private val seats: PriorityQueue<Int> = PriorityQueue()

    init {
        (1..n).forEach { i ->
            seats.offer(i)
        }
    }

    fun reserve(): Int {
        return when {
            seats.isNotEmpty() -> {
                seats.poll()
            }
            else -> {
                -1
            }
        }
    }

    fun unreserve(seatNumber: Int) {
        seats.offer(seatNumber)
    }
}