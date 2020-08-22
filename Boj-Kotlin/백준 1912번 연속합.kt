package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val input=br.readLine().split(" ")
    val arr=ArrayList<Int>()
    val dp=Array(n){0}
    for(i in input)
        arr.add(i.toInt())
    for(i in 0 until n step 1)
    {
        dp[i]=arr[i]
        if (i==0)
            continue
        if(dp[i]<dp[i-1]+arr[i])
            dp[i]=dp[i-1]+arr[i]
    }
    println(dp.max())
}