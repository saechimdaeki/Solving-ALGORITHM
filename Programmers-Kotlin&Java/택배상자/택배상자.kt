package 코틀린.택배상자

import java.util.Stack

class Solution {
    fun solution(order: IntArray): Int {
        var idx = 0
        val spareBelt = Stack<Int>()
        val mainBelt = mutableListOf<Int>()

        for(i in 0 until order.size) {
            spareBelt.push(i + 1)
            while (spareBelt.isNotEmpty()) {
                if(spareBelt.peek() == order[idx]) {
                    mainBelt.add(spareBelt.pop())
                    idx++
                }else break
            }
        }

        return mainBelt.size
    }
}

fun main() {
    Solution().apply {
        println(solution(intArrayOf(4,3,1,2,5))) // 2
//        println(solution(intArrayOf(5,4,3,2,1))) // 5
    }
}