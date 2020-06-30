package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    var input=br.readLine().split(" ")
    var arr=ArrayList<Int>()
    var dp=Array(n+1){0}
    for(i in input)
        arr.add(i.toInt())
    for(i in 0 until n step 1)
    {
        dp[i]=1
        for(j in 0 until i step 1)
        {
            if(arr[j]<arr[i] && dp[i]<dp[j]+1)
                dp[i]=dp[j]+1
        }
    }
    print(dp.max())
}