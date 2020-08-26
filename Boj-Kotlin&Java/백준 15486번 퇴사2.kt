import kotlin.math.max

fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val t=Array(n){0}
    val p=Array(n){0}
    val dp=Array(n+50){0}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it.toInt() }
        t[i]=input[0]
        p[i]=input[1]
    }
    for(i in 0 until n)
    {
        dp[i+t[i]]= max(dp[i+t[i]],dp[i]+p[i])
        dp[i+1]= max(dp[i+1],dp[i])
    }
    println("${dp[n]}")
}