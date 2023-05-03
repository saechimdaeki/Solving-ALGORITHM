package boj11057

fun main() {
    val n = readLine()!!.toInt()

    val dp = Array(n+1){IntArray(10)}
    for(i in 0 .. 9) {
        dp[1][i] = 1
    }

    for (len in 2.. n) {
        for(num in 0 .. 9) {
            for(prev in 0 .. num) {
                dp[len][num] += dp[len -1][prev]
                dp[len][num] %= 10007
            }
        }
    }
    var answer = 0

    for(i in 0 .. 9) {
        answer += dp[n][i]
        answer %= 10007
    }
    println(answer)
}