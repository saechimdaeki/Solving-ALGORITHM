package 백준

import java.util.*

private val pq=PriorityQueue<Long>()
fun main() {
    val br=System.`in`.bufferedReader()
    val (k,n)=br.readLine().split(" ").map { it.toInt() }
    val arr=br.readLine().split(" ").map { it.toLong() }.toLongArray()

    arr.indices.forEach { i ->
        with(pq) { offer(arr[i]) }
    }
    var answer=0L
    for(i in 0 until n){
        answer=pq.poll()
        for(j in 0 until k){
            val temp=answer*arr[j]
            pq.offer(temp)
            if(answer%arr[j]==0L) break
        }
    }
    print(answer)
}
