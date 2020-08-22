import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:Array<ArrayList<choidan>>
private lateinit var dist:Array<Int>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (v,e)=br.readLine().split(" ").map{it.toInt()}
    val start=br.readLine().toInt()
    dist=Array(v+1){1000000000}
    arr=Array(v+1){ ArrayList<choidan>() }
    dist[start]=0
    repeat(e){
        val (x,y,z)=br.readLine().split(" ").map{it.toInt()}
        arr[x].add(choidan(y,z))
    }
    val pq=PriorityQueue<choidan>()
    pq.offer(choidan(start,0))
    while (pq.isNotEmpty())
    {
        val tmp=pq.poll()
        val nowidx=tmp.index
        val nowcost=tmp.cost
        if(dist[nowidx]<nowcost)
            continue
        for(i in 0 until arr[nowidx].size)
        {
            if(dist[nowidx]+arr[nowidx][i].cost<dist[arr[nowidx][i].index])
            {
                dist[arr[nowidx][i].index]=dist[nowidx]+arr[nowidx][i].cost
                pq.offer(choidan(arr[nowidx][i].index,dist[nowidx]+arr[nowidx][i].cost))
            }
        }
    }
    for(i in 1..v)
    {
        if(dist[i]==1000000000)
            bw.write("INF\n")
        else
            bw.write("${dist[i]}\n")
    }
    bw.flush()
}
private class choidan:Comparable<choidan>{
    var index=0
    var cost=0

    constructor(index: Int, cost: Int) {
        this.index = index
        this.cost = cost
    }

    override fun compareTo(other: choidan): Int {
        if(this.cost<other.cost)
            return -1
        return 1
    }

}