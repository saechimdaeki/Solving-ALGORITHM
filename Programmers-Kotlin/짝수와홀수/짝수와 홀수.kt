package 프로그래머스.짝수와홀수

class Solution {
    fun solution(num: Int): String {
        return when {
            num%2==0 -> "Even"
            else -> "Odd"
        }
    }
}

fun main() {
    val s=Solution()
    println(s.solution(3))
    println(s.solution(4))
}