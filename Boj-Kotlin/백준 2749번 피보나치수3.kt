private const val Mod=1000000
fun main() {
    val n=System.`in`.bufferedReader().readLine().toLong()
    val dp=Array(1500000){0L}
    dp[0]=0
    dp[1]=1
    for(i in 2 until 1500000 )
    {
        dp[i]=dp[i-1]+dp[i-2]
        dp[i]= dp[i]%Mod
    }
    println(dp[(n%1500000).toInt()])
}