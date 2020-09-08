package 프로그래머스.자릿수더하기

class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        var tmp=n.toString()
        for(i in tmp.indices)
            answer+=tmp[i]-'0'
        return answer
    }
}

fun main() {
    val s=Solution()
    println(s.solution(123))
    println(s.solution(987))
}