package 코틀린.호텔대실

import java.util.PriorityQueue


class Solution {
    fun solution(book_time: Array<Array<String>>): Int {

        val list = arrayListOf<Pair<Int,Int>>()

        book_time.forEach { time ->
            val enterTime = time[0].split(":").run {
                this[0].toInt() * 60 + this[1].toInt()
            }
            val quitTime = time[1].split(":").let {
                it[0].toInt() * 60 + it[1].toInt() + 10
            }
            list.add(Pair(enterTime , quitTime))
        }

        list.sortWith(compareBy({it.first}, {it.second}))

        val pq = PriorityQueue<Int>()

        list.forEach { time ->
            if (pq.isNotEmpty() && pq.peek() <= time.first) {
                pq.remove()
            }
            pq.add(time.second)
        }
        return pq.size
    }
}

fun main() {
    Solution().apply {
        println(this.solution(arrayOf(arrayOf("15:00", "17:00"), arrayOf("16:40", "18:20"),
                arrayOf("14:20", "15:20"), arrayOf("14:10", "19:20"), arrayOf("18:20", "21:20")))) //3
        println(this.solution(arrayOf(arrayOf("09:10", "10:10"), arrayOf("10:20", "12:20")))) // 1
        println(this.solution(arrayOf(arrayOf("10:20", "12:30"), arrayOf("10:20", "12:30"), arrayOf("10:20", "12:30")))) //3
    }
}