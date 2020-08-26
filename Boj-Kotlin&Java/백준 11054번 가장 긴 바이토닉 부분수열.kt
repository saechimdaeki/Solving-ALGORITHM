package boj14681kot

import kotlin.math.max

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=Array(n+1){0}
    var dp=Array(n+1){0}//증가
    var dp2=Array(n+1){0}//감소
    val input=br.readLine().split(" ")
    for(i in input.indices)
        arr[i]=input[i].toInt()
    for(i in 0 until n)
    {
        dp[i]=1
        for(j in 0 until i)
        {
            if(arr[j]<arr[i] && dp[j]+1>dp[i])
                dp[i]=dp[j]+1
        }
    }

    for(i in n-1 downTo 0 )
    {
        dp2[i]=1
        for(j in i+1 until n)
        {
            if(arr[i]>arr[j] && dp2[j]+1>dp2[i])
                dp2[i]=dp2[j]+1
        }
    }
    var answer=0
    for(i in 0 until n)
        answer= max(answer,dp[i]+dp2[i]-1)
    println(answer)
}