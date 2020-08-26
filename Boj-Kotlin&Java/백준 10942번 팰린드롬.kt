fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it.toInt() }
    val dp=Array(n){Array(n){false}}
    for(i in 0 until n)
        dp[i][i]=true
    for(i in 0 until n-1)
    {
        if(arr[i]==arr[i+1])
            dp[i][i+1]=true
    }
    for(i in 2 until n)
    {
        for(j in 0 until n-i)
        {
            val k=i+j
            if(arr[j]==arr[k] && dp[j+1][k-1])
                dp[j][k]=true
        }
    }
    val m=br.readLine().toInt()

    for(i in 0 until m)
    {
        val (a, b)=br.readLine().split(" ").map { it.toInt() }
        if(dp[a-1][b-1])
            bw.write("1\n")
        else
            bw.write("0\n")
    }
    bw.flush()
}