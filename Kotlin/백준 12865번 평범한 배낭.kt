import kotlin.math.max

fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val (n,k)=br.readLine().split(" ").map { it.toInt() }
    val weight=Array(n+1){0}
    val value=Array(n+1){0}
    val dp=Array(k+1){0}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it.toInt() }
        weight[i]=input[0]
        value[i]=input[1]
    }
    for(i in 0 until n)
    {
        for(j in k downTo 1)
        {
            if(j-weight[i]>=0)
                dp[j]= max(dp[j],dp[j-weight[i]]+value[i])
        }
    }
    println(dp[k])

}