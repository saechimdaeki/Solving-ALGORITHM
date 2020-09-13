package 백준

import kotlin.math.max

fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    var (health,happy)= intArrayOf(100,0)
    val a=br.readLine().split(" ").map { it.toInt() }
    val b=br.readLine().split(" ").map { it.toInt() }
    val dp= IntArray(100)
    for(i in 0 until n){
        for(j in 99 downTo a[i] step 1){
            dp[j]= max(dp[j],dp[j-a[i]]+b[i])
        }
    }
    println("${dp[99]}")
}