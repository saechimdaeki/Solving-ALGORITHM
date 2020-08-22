package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val input=br.readLine().split(" ")
    val arr=Array(n+1){0}
    val dp=Array(n+1){0}
    for(i in 0 until n)
        arr[i]=input[i].toInt()
    for(i in 0 until n)
    {
        dp[i]=1
        for(j in 0 until i)
        {
            if(arr[j] >arr[i] && dp[i]<dp[j]+1)
                dp[i]=dp[j]+1
        }
    }
    println(dp.max())
}