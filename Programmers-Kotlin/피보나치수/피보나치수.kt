package 메인디렉.피보나치수

class Solution {
    fun solution(n: Int): Int {
        val dp=Array(100001){0}
        dp[0]=0
        dp[1]=1
        for(i in 2..n)
            dp[i]=(dp[i-1]+dp[i-2])%1234567
        return dp[n]%1234567
    }
}

fun main() {
    val s=Solution()
    println(s.solution(3))
    println(s.solution(5))
}