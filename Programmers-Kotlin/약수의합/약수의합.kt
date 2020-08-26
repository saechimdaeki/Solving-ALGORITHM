package 프로그래머스.약수의합

class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        for(i in 1..n)
            if(n%i==0)
                answer+=i
        return answer
    }
}

fun main() {
    val s=Solution()
    println(s.solution(12))
    println(s.solution(5))
}