package boj14681kot

import kotlin.math.min

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val dp=Array(1001){Array(3){0} }
    val arr=Array(1001){Array(3){0} }
    //0 은 빨강 1은 초록 2는 파랑
    for(i in 1..n)
    {
        val tmp=br.readLine().split(" ")
        for(j in tmp.indices)
            arr[i][j]=tmp[j].toInt()
    }
    for( i in 1..n)
    {
        dp[i][0]= min(dp[i-1][1],dp[i-1][2])+arr[i][0]
        dp[i][1]=min(dp[i-1][0],dp[i-1][2])+arr[i][1]
        dp[i][2]=min(dp[i-1][0],dp[i-1][1])+arr[i][2]
    }
    println(min(min(dp[n][0],dp[n][1]),dp[n][2]))
}