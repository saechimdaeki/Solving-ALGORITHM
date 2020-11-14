package 백준

import kotlin.system.exitProcess

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var (n,k)=br.readLine().split(" ").map { it.toLong() }
    val dp=Array(n.toInt()+1){LongArray(n.toInt()+1)}
    dp[0][0]=1
    (1..n.toInt()).forEach { i ->
        dp[0][i]=0
    }
    (1..n.toInt()).forEach { i ->
        dp[i][0]=dp[i-1][1]
        (1.. n.toInt()).forEach { j ->
            dp[i][j]=dp[i-1][j-1]
            when {
                j+1<=n -> {
                    dp[i][j]+=dp[i-1][j+1]
                }
            }
        }
    }
    if(k>=dp[n.toInt()][0]){
        println(-1)
        exitProcess(0)
    }
    var current=0
    (n.toInt() downTo 1).forEach { i ->
        when (current) {
            0 -> {
                bw.write("(")
                current+=1
            }
            else -> {
                if(k<dp[i-1][current+1]){
                    bw.write("(")
                    current+=1
                }else{
                    bw.write(")")
                    k-=dp[i-1][current+1]
                    current--
                }
            }
        }
    }
    bw.flush()
}