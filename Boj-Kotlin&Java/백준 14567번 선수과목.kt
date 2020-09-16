package 백준

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:Array<ArrayList<Int>>
private lateinit var indegree:IntArray
private lateinit var outdegree:IntArray
private val bw=System.out.bufferedWriter()
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n+1){ArrayList<Int>()}
    indegree= IntArray(n+1)
    outdegree= IntArray(n+1)
    repeat(m){
        val (a,b)=br.readLine().split(" ").map { it.toInt() }
        arr[a].add(b)
        indegree[b]++
    }
    bfs(n)
    bw.flush()
}
private fun bfs(n:Int){
    val q=LinkedList<Pair<Int,Int>>()
    for(i in 1..n){
        if(indegree[i]==0) {
            q.offer(Pair(i, 0))
        }
    }
    while (q.isNotEmpty()){
        val now=q.poll()
        for(i in 0 until arr[now.first].size){
            val v=arr[now.first][i]
            indegree[v]--
            if(indegree[v]==0){
                outdegree[v]=now.second+1
                q.offer(Pair(v,now.second+1))
            }
        }
    }
    for(i in 1..n)
        bw.write("${outdegree[i]+1} ")
}