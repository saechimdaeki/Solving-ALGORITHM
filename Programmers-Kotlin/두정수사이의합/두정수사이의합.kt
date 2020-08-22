package 메인디렉.두정수사이의합

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        val (start,end)= intArrayOf(min(a,b), max(a,b))
        for(i in start..end)
            answer+=i
        return answer
    }
}

fun main() {
    val a= Solution()
    println(a.solution(3,5))
    println(a.solution(3,3))
    println(a.solution(5,3))

}