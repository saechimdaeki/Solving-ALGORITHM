package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val mod:Long =1000000009
    val n=br.readLine().toInt()
    val dp =LongArray(1000001){0}
    dp[0]=1
    for(i in 0 until 1000001)
    {
        if(i-1>=0)
            dp[i]+=dp[i-1]
        if(i-2>=0)
            dp[i]+=dp[i-2]
        if(i-3>=0)
            dp[i]+=dp[i-3]
        dp[i]%=mod
    }
    for(i in 0 until n)
    {
        val tmp=br.readLine().toInt()
        bw.write(dp[tmp].toString())
        bw.write("\n")
    }
    bw.flush()
}