package 백준

import java.util.*
import kotlin.collections.ArrayList


data class node20010(val to:Int,val cost:Int)
private lateinit var graph:Array<ArrayList<node20010>>
private lateinit var parent:IntArray
private lateinit var dist:IntArray
private lateinit var visited:BooleanArray
private val arr= arrayListOf<Triple<Int,Int,Int>>()
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,k)=br.readLine().split(" ").map { it.toInt() }
    parent= IntArray(n+1){it}
    repeat(k){
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        arr.add(Triple(a,b,c))
    }
    arr.sortBy { it.third }
    var minst=0
    graph=Array(n+1){ arrayListOf<node20010>() }
    for(i in 0 until k) {
        val tmp = arr[i]
        if (find(tmp.first) != find(tmp.second)) {
            minst += tmp.third
            union(tmp.first, tmp.second)
            graph[tmp.first].add(node20010(tmp.second,tmp.third))
            graph[tmp.second].add(node20010(tmp.first,tmp.third))
        }
    }
    bfs(n,0)
    var vertex=1
    for(i in 1 until n){
        if(dist[i]>dist[vertex])
            vertex=i
    }
    var answer=dist[0]
    bfs(n,vertex)
    for(i in 0 until n){
        if(answer<dist[i])
            answer=dist[i]
    }
    bw.write("$minst\n")
    bw.write("$answer")
    bw.flush()
}
private fun find(x:Int):Int{
    if(x==parent[x])
        return x
    parent[x]=find(parent[x])
    return parent[x]
}
private fun union(x:Int,y:Int){
    val (px,py)= intArrayOf(find(x),find(y))
    if(px<py)
        parent[py]=px
    else
        parent[px]=py
}
private fun bfs(v:Int,vertex:Int){
    visited= BooleanArray(v+1)
    dist= IntArray(v+1)
    val q=LinkedList<Int>()
    q.offer(vertex)
    visited[vertex]=true
    while (q.isNotEmpty()){
        val now=q.poll()
        for(i in graph[now]){
            val to=i.to
            val cost=i.cost
            if(!visited[to]){
                dist[to]=dist[now]+cost
                q.offer(to)
                visited[to]=true
            }
        }
    }
}
