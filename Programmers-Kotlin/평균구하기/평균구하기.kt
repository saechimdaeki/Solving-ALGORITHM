package 프로그래머스.평균구하기

class Solution {
    fun solution(arr: IntArray): Double {
        var answer= arr.sum().toDouble()
        return answer/arr.size
    }
}

fun main() {
    val s=Solution()
    println(s.solution(intArrayOf(1,2,3,4)))
    println(s.solution(intArrayOf(5,5)))
}