package 백준

import java.util.*
import kotlin.system.exitProcess

fun main() {
    val br=System.`in`.bufferedReader()
    val (a,b)=br.readLine().split(" ").map { it.toInt() }
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val arr=Array(n+1){IntArray(n+1)}
    val dist=Array(n+1){-1 }
    repeat(m){
        val (n1,n2)=br.readLine().split(" ").map { it.toInt() }
        arr[n1][n2]=1
        arr[n2][n1]=1
    }
    dist[a]=0
    val q=LinkedList<Int>()
    q.offer(a)
    while (q.isNotEmpty()){
        val now=q.poll()
        when (now) {
            b -> {
                println("${dist[now]}")
                exitProcess(0)
            }
        }
        (1..n).forEach { i ->
            when {
                dist[i]==-1 && arr[now][i]==1 -> {
                    dist[i]=dist[now]+1
                    q.offer(i)
                }
            }
        }
    }
    println(-1)
}
