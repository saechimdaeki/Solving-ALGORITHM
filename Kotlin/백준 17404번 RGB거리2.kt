package boj14681kot

import kotlin.math.min

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=Array(n+1){Array(3){0} }
    val dp=Array(n+1){Array(3){0} }
    for(i in 1..n)
    {
        val input=br.readLine().split(" ")
        for(j in 0 until 3)
            arr[i][j]=input[j].toInt()
    }
    var ans=1000*1000+1
    for(k in 0..2)
    {
        for( j in 0..2 )
        {
            if(j==k)
                dp[1][j]=arr[1][j]
            else
                dp[1][j]=1000*1000+1
        }
        for(i in 2..n)
        {
            dp[i][0]= min(dp[i-1][1],dp[i-1][2])+arr[i][0]
            dp[i][1]= min(dp[i-1][0],dp[i-1][2])+arr[i][1]
            dp[i][2]= min(dp[i-1][0],dp[i-1][1])+arr[i][2]
        }
        for(j in 0..2)
        {
            if(j==k)
                continue
            ans=min(ans,dp[n][j])
        }
    }
    println(ans)


}