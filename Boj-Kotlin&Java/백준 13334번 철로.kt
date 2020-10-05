package 백준

import java.util.PriorityQueue

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val arr= arrayListOf<Pair<Int,Int>>()
    repeat(n){
        val (a,b)=br.readLine().split(" ").map { it.toInt() }
        arr.add(Pair(minOf(a,b), maxOf(a,b)))
    }
    arr.sortBy { it.second }
    val d=br.readLine().toInt()
    var answer=-12345
    val pq=PriorityQueue<Int>()
    for(i in 0 until n){
        pq.offer(arr[i].first)
        while (pq.isNotEmpty() && (arr[i].second-pq.peek()>d)){
                pq.remove()
        }
        answer= maxOf(answer,pq.size)
    }
    bw.write("$answer")
    bw.flush()
}
