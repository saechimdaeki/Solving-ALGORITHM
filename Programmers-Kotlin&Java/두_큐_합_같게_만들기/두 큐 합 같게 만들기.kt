package 코틀린.programmers.두_큐_합_같게_만들기

import java.util.LinkedList


class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer = 0
        val lq = LinkedList<Int>()
        val rq = LinkedList<Int>()

        queue1.indices.forEach { i ->
            lq.add(queue1[i])
            rq.add(queue2[i])
        }

        var lSum = queue1.sum().toLong()
        var rSum = queue2.sum().toLong()
        val sum = lSum + rSum
        if ((sum %2).toInt() != 0) return -1

        while (true) {
            if (answer > (queue1.size + queue2.size) * 2) return -1
            if (lSum == rSum) break

            if (lSum < rSum) {
                val poll = rq.poll()
                lSum += poll
                rSum -= poll
                lq.add(poll)
            } else {
                val poll = lq.poll()
                lSum -= poll
                rSum += poll
                rq.add(poll)
            }
            answer ++
        }


        return answer
    }
}


fun main() {
    Solution().apply {
        println(this.solution(intArrayOf(3,2,7,2), intArrayOf(4,6,5,1))) //2
        println(this.solution(intArrayOf(1,2,1,2), intArrayOf(1,10,1,2))) //7
        println(this.solution(intArrayOf(1,1), intArrayOf(1,5))) //-1

    }
}