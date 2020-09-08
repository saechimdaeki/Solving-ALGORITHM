package 프로그래머스.정수내림차순으로배치하기

class Solution {
    fun solution(n: Long): Long {
        val s=n.toString().toCharArray()
        s.sortDescending()
        val answerstring=s.joinToString("")
        return answerstring.toLong()
    }
}


fun main() {
    val s=Solution()
    println(s.solution(118372))
}