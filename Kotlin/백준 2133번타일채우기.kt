package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val dp=LongArray(n+1){0}
    dp[0]=1
    for(i in 2.. n step 2)
    {
        dp[i]=dp[i-2]*3
        for(j in i-4 downTo 0 step 2)
            dp[i]+=dp[j]*2
    }
    println(dp[n])
}