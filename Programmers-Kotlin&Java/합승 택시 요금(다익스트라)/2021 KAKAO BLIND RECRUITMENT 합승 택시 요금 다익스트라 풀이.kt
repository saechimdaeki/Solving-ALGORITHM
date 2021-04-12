package kakao

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.cos

class Solution {
    private lateinit var graph:Array<ArrayList<Edge>>
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer=Int.MAX_VALUE
        graph=Array(n+1){ArrayList<Edge>()}
        for(i in fares.indices){
            graph[fares[i][0]].add(Edge(fares[i][1],fares[i][2]))
            graph[fares[i][1]].add(Edge(fares[i][0],fares[i][2]))
        }
        var A= IntArray(n+1){20000001}
        var B=IntArray(n+1){20000001}
        var start=IntArray(n+1){20000001}

        A=dijkstra(a,A)
        B=dijkstra(b,B)
        start=dijkstra(s,start)
        for(i in 1 until n+1)
            answer= minOf(answer,A[i]+B[i]+start[i])
        return answer
    }
    fun dijkstra(s:Int,cost:IntArray):IntArray{
        val pq=PriorityQueue<Edge>()
        pq.offer(Edge(s,0))
        cost[s]=0
        while (pq.isNotEmpty()){
            val nowEdge=pq.poll()
            val (now,nowcost)= arrayOf(nowEdge.index,nowEdge.cost)
            if(nowcost> cost[now]) continue
            val edges=graph[now]
            for (edge in edges) {
                val co=cost[now]+edge.cost
                if(co<cost[edge.index]){
                    cost[edge.index]=co
                    pq.offer(Edge(edge.index,co))
                }
            }
        }
        return cost
    }

    internal class Edge(var index: Int, var cost: Int) : Comparable<Edge> {
        override fun compareTo(e: Edge): Int {
            return this.cost-e.cost
        }
    }
}

