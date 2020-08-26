package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    var dp=LongArray(n+1){0}
    dp[1]=1;
    if(n>=2)
        dp[2]=1
    for(i in 3..n)
        dp[i]=dp[i-1]+dp[i-2]
    print(dp[n])
}