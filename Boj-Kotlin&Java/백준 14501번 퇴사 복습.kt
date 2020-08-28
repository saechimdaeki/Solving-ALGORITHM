package 백준

import kotlin.math.max

private lateinit var tarray:IntArray
private lateinit var parray:IntArray
private var answer=-1
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    tarray= IntArray(n)
    parray= IntArray(n)
    for(i in 0 until n){
        val (x,y)=br.readLine().split(" ").map { it.toInt() }
        tarray[i]=x
        parray[i]=y
    }
    dfs(0,0,n)
    println(answer)
}
private fun dfs(day:Int,sum:Int,n:Int){
    if(day==n){
        answer= max(answer,sum)
        return
    }
    if(day>n)
        return
    dfs(day+1,sum,n)
    dfs(day+ tarray[day],sum+ parray[day],n)
}