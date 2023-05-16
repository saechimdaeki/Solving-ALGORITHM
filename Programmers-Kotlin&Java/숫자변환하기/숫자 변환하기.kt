package 코틀린.숫자변환하기

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {

        val dp = IntArray(y + 1) { Int.MAX_VALUE }
        dp[x]=0
        for (i in x..y) {
            if (dp[i] == Int.MAX_VALUE) continue
            if (i + n <= y)
                dp[i + n] = minOf(dp[i + n], dp[i] + 1)
            if (i * 2 <= y)
                dp[i * 2] = minOf(dp[i * 2], dp[i] + 1)
            if (i * 3 <= y)
                dp[i * 3] = minOf(dp[i * 3], dp[i] + 1)
        }
        return if(dp[y]== Int.MAX_VALUE) -1 else dp[y]

    }
}

fun main() {
    Solution().apply {
        println(this.solution(10, 40, 5)) //2
        println(this.solution(10, 40, 30)) //1
        println(this.solution(2, 5, 4)) // -1


    }
}