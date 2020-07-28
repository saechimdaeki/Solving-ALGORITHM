private const val mod=10007
fun main() {
    val (n,k)=System.`in`.bufferedReader().readLine().split(" ").map { it.toInt() }
    val dp=Array(n+1){Array(n+1){0}}
    for(i in 0 ..n )
    {
        dp[i][0]=1
        dp[i][i]=1
        for(j in 1 until i)
        {
            dp[i][j]=dp[i-1][j-1]+dp[i-1][j]
            dp[i][j]=dp[i][j]%mod
        }
    }
    println(dp[n][k])
}