import java.util.*

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map{it.toInt()}
    val arr=br.readLine().split(" ").map{it.toLong()}.toTypedArray()
    val pq=PriorityQueue<Long>()
    for(i in arr)
        pq.offer(i)
    for(i in 0 until m)
    {
        var x=pq.poll()
        var y=pq.poll()
        val tmp=x+y
        x=tmp
        y=tmp
        pq.offer(x)
        pq.offer(y)
    }
    var sum=0L
    while (pq.isNotEmpty())
    {
        sum+=pq.poll()
    }
    println(sum)
}