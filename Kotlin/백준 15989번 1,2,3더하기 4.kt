fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    val dp=Array(10001){0}
    dp[0]=1
    for(i in 1 ..10000)
    {
        if(i-1>=0)
            dp[i]+=dp[i-1]
    }
    for(i in 1 .. 10000)
    {
        if(i-2>=0)
            dp[i]+=dp[i-2]
    }
    for( i in 1..10000)
    {
        if(i-3>=0)
            dp[i]+=dp[i-3]
    }
    for(i in 0 until t)
        bw.write("${dp[br.readLine().toInt()]}\n")
    bw.flush()
}