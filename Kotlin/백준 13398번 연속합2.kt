package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val input=br.readLine().split(" ")
    val arr=Array(n){0}
    val dp=Array(n){0}
    val dp2=Array(n){0}
    for(i in 0 until n)
        arr[i]=input[i].toInt()
    for(i in 0 until n)
    {
        dp[i]=arr[i]
        if(i>0 &&dp[i]<dp[i-1]+arr[i])
            dp[i]=dp[i-1]+arr[i]
    }
    for(i in n-1 downTo 0)
    {
        dp2[i]=arr[i]
        if(i<n-1 && dp2[i]<dp2[i+1]+arr[i])
            dp2[i]=dp2[i+1]+arr[i]
    }
    var answer:Int? = dp.max()
    for(i in 1 until n-1){
        if(answer!! < dp[i-1]+dp2[i+1])
            answer=dp[i-1]+dp2[i+1]
        }
    println(answer)
}