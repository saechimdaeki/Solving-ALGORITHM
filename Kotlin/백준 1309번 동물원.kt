package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val mod=9901
    val n=br.readLine().toInt()
    val dp=Array(n+1){Array(3){0} }
    dp[0][0]=1
    for(i in 1..n)
    {
        dp[i][0]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2]
        dp[i][1]=dp[i-1][0]+dp[i-1][2]
        dp[i][2]=dp[i-1][0]+dp[i-1][1]
        for(j in 0 until 3)
            dp[i][j]%=mod
    }
    println((dp[n][0]+dp[n][1]+dp[n][2])%mod)

}