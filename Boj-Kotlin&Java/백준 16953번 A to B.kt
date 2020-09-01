package 백준

import kotlin.math.min

fun main() {
    val (a,b)=System.`in`.bufferedReader().readLine().split(" ").map { it.toLong() }
    println("${dfs(a,b)}")
}
private fun dfs(a:Long,b:Long):Int{
    if(a==b) return 1
    if(a>b) return -1
    val tmp1=dfs(a*2,b)
    val tmp2=dfs(a*10+1,b)
    if(tmp1==-1 && tmp2==-1) return -1
    if(tmp1==-1) return tmp2+1
    if(tmp2==-1) return tmp1+1
    return min(tmp1,tmp2)+1
}