package boj2579

fun main() {
    val n = readLine()!!.toInt()
    val arr = IntArray(n + 1)
    for (i in 1..n)
        arr[i] = readLine()!!.toInt()
    val dp = Array(n + 1) { IntArray(2) }

    dp[1][0] = 0
    dp[1][1] = arr[1]

    if (n >= 2) {
        dp[2][0] = arr[2]
        dp[2][1] = arr[1] + arr[2]
    }
    for (i in 3..n) {
        dp[i][0] = maxOf(dp[i - 2][0] + arr[i], dp[i - 2][1] + arr[i])
        dp[i][1] = dp[i - 1][0] + arr[i]
    }

    println(maxOf(dp[n][0], dp[n][1]))

}