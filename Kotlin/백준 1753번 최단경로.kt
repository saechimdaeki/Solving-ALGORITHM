import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:Array<ArrayList<Pair<Int,Int>>>
private lateinit var dist:Array<Int>
fun main() {
    val br=System.`in`.bufferedReader()
    val (v,e)=br.readLine().split(" ").map { it.toInt()}
    val start=br.readLine().toInt()
    arr=Array(v+1){ArrayList<Pair<Int,Int>>()}
    dist=Array(v+1){ Int.MAX_VALUE}
    repeat(e){
        val (u,v,w)=br.readLine().split(" ").map { it.toInt()}
        arr[u].add(Pair(v,w))
    }
    dist[start]=0
    val pq=PriorityQueue<pair>()
    pq.offer(pair(0,start))
    while (pq.isNotEmpty())
    {
        val (nowdist,now)=pq.poll()
        if(dist[now]<nowdist)
            continue
        for( i in arr[now])
        {
            if(dist[i.first]>nowdist+i.second){
                dist[i.first]=nowdist+i.second
                pq.offer(pair(nowdist+i.second,i.first))
            }
        }
    }
    for(i in 1..v)
        println(if(dist[i]== Int.MAX_VALUE) "INF" else "${dist[i]}")


}
data class pair(val dist:Int, val vertex:Int):Comparable<pair>{
    override fun compareTo(other: pair): Int {
        return when {
            dist<other.dist -> -1
            dist > other.dist -> 1
            else -> 0
        }
    }
}