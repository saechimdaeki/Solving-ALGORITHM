package 프로그래머스.정수제곱근판별

class Solution {
    fun solution(n: Long): Long {
        for(i in 1..n)
        {
            if(i*i==n)
                return (i+1)*(i+1)
        }
        return -1
    }
}

fun main() {
    val s= Solution()
    println(s.solution(121))
    println(s.solution(3))
}