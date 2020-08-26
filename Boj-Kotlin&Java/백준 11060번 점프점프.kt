fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    val dp=Array(n){-1}
    dp[0]=0
    for(i in 0 until n-1 )
    {
        if(dp[i]==-1)
            continue
        for(j in 1 .. arr[i])
        {
            if(i+j>=n)
                break
            if(dp[i+j]==-1||dp[i+j]>dp[i]+1)
                dp[i+j]=dp[i]+1
        }
    }
    println("${dp[n-1]}")
}