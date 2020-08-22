import java.util.*
import kotlin.collections.ArrayList

private const val inf=1000000000
private lateinit var arr:Array<ArrayList<node1719>>
private lateinit var dist:Array<Int>
private val bw=System.out.bufferedWriter()
/* 다익스트라 스피드코딩 연습*/
fun main() {
    val br=System.`in`.bufferedReader()

    val (n,m)=br.readLine().split(" ").map{it.toInt()}
    arr=Array(n+1){ArrayList<node1719>()}
    dist=Array(n+1){inf}
    repeat(m){
        val (a,b,c)=br.readLine().split(" ").map{it.toInt()}
        arr[a].add(node1719(b,c))
        arr[b].add(node1719(a,c))
    }
    for(i in 1..n)
        dijkstra(i,n)
    bw.flush()
}
private fun dijkstra(x:Int,n:Int){
    val pq=PriorityQueue<node1719>()
    val visited=Array(n+1){false}
    val track=Array(n+1){0}
    dist.fill(element = inf)
    dist[x]=0
    track[x]=x
    pq.offer(node1719(x,0))
    while (pq.isNotEmpty())
    {
        val now=pq.poll()
        val nowidx=now.index
        val nowdist=now.dist
        if(visited[nowidx])
            continue
        visited[nowidx]=true
        for(next in arr[nowidx])
        {
            if(dist[next.index]>dist[nowidx]+next.dist)
            {
                dist[next.index]=dist[nowidx]+next.dist
                track[next.index]=nowidx
                pq.offer(node1719(next.index,dist[next.index]))
            }
        }
    }
    write(x,track,n)
}
private fun write(x:Int,track:Array<Int>,n:Int){
    for (v in 1..n) {
        if (v == x) {
            bw.write("- ")
            continue
        }
        var answer = 0
        var j = v
        while (j != x) {
            answer = j
            j = track[j]
        }
        bw.write("$answer ")
    }
    bw.write("\n")
}
private class node1719:Comparable<node1719> {
    var index=0
    var dist=0
    constructor(index: Int, dist: Int) {
        this.index = index
        this.dist = dist
    }
    override fun compareTo(other: node1719): Int {
        if(this.dist<other.dist)
            return -1
        return 1
    }
}