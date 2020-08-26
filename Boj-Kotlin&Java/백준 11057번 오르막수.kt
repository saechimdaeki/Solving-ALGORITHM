package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val mod=10007
    val n=br.readLine().toInt()
    val dp=Array(n+1){Array(10){0} }
    for(i in 0..9)
        dp[1][i]=1
    for(i in 2..n)
    {
        for( j in 0..9)
        {
            for(k in 0..j)
            {
                dp[i][j]+=dp[i-1][k]
                dp[i][j]%=mod
            }
        }
    }
    var ans=0
    for(i in 0 until 10)
        ans+=dp[n][i]
    println(ans%mod)
}