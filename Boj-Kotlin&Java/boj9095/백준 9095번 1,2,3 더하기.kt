package boj9095

val bw = System.out.bufferedWriter()
val dp = IntArray(11)
fun main() {
    val t = readLine()!!.toInt()
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    (4 until 11).forEach { i ->
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
    }
    repeat(t) {
        bw.write("${dp[readLine()!!.toInt()]}\n")
    }
    bw.flush()
}