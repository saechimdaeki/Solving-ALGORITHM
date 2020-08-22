package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    var dp=Array(n+1){LongArray(n+1){0} }
    dp[1][0]=0
    dp[1][1]=1
    for(i in 2..n step 1)
    {
        dp[i][0]=dp[i-1][0]+dp[i-1][1]
        dp[i][1]=dp[i-1][0]
    }
    print(dp[n][0]+dp[n][1])
}