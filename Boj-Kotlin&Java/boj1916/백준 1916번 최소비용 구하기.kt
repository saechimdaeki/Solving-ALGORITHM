package boj1916

import java.util.PriorityQueue


fun main() {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val arr = Array(n+1){ mutableListOf<Pair<Int,Int>>() }
    val dist = IntArray(n+1){ Int.MAX_VALUE }
    repeat(m) {
        val (start, end, cost) = readLine()!!.split(" ").map { it.toInt() }
        arr[start].add(Pair(end, cost))
    }
    val (start, end) = readLine()!!.split(" ").map { it.toInt() }
    dist[start] = 0
    val pq = PriorityQueue<Pair<Int,Int>>{ o1, o2 ->
        o1.first - o2.first
    }

    pq.add(Pair(dist[start], start))
    while (pq.isNotEmpty()) {
        val (distance,nowCost) = pq.poll()

        if(dist[nowCost] < distance) continue

        for(i in 0 until arr[nowCost].size) {
            val next = arr[nowCost][i]
            val (nextCost, nextDistance) = next
            if(dist[nextCost] > distance + nextDistance) {
                dist[nextCost] = distance + nextDistance
                pq.add(Pair(dist[nextCost], nextCost))
            }
        }
    }
    println(dist[end])
}
