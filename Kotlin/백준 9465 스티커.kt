package boj14681kot

import kotlin.math.max

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    for(tc in 0 until t step 1) {
        val n = br.readLine().toInt()
        val arr = Array(n+2) { Array(2) { 0 } }
        val dp = Array(n+2) { Array(3) { 0 } }
        val line1 = br.readLine().split(" ")
        val line2 = br.readLine().split(" ")
        for (i in 1.. n)
            arr[i][0] = line1[i-1].toInt()
        for (i in 1.. n)
            arr[i][1] = line2[i-1].toInt()
        dp[0][0]=0
        dp[0][1]=0
        dp[0][2]=0
        for(i in 1..n)
        {
            dp[i][0]= max(max(dp[i-1][0],dp[i-1][1]),dp[i-1][2])
            dp[i][1]= max(dp[i-1][0],dp[i-1][2])+arr[i][0]
            dp[i][2]= max(dp[i-1][0],dp[i-1][1])+arr[i][1]
        }
        bw.write("${max(max(dp[n][0],dp[n][1]),dp[n][2])}\n")

    }
    bw.flush()
}