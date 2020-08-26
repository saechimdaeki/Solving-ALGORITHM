package boj14681kot

import kotlin.math.min
import kotlin.math.sqrt

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val dp=Array(n+1){0}
    for(i in 1 ..n step 1)
    {
        dp[i]=i
        for(j in 1..sqrt(i.toDouble()).toInt() step 1)
            dp[i]= min(dp[i],dp[i-j*j]+1)
    }
    println(dp[n])
}