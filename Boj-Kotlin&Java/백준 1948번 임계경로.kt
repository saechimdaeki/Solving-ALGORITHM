import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:Array<ArrayList<Pair<Int,Int>>>
private lateinit var brr:Array<ArrayList<Pair<Int,Int>>>
private lateinit var adegree:Array<Int>
private lateinit var dist:Array<Int>
private lateinit var bdegree:Array<Int>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val m=br.readLine().toInt()
    arr=Array(n+1){ArrayList<Pair<Int,Int>>() }
    brr=Array(n+1){ArrayList<Pair<Int,Int>>()}
    adegree=Array(n+1){0}
    dist=Array(n+1){0}
    bdegree=Array(n+1){0}
    repeat(m){
        val (a,b,c)=br.readLine().split(" ").map{it.toInt()}
        arr[a].add(Pair(b,c))
        brr[b].add(Pair(a,c))
        adegree[b]++
        bdegree[a]++
    }
    val (start,end)=br.readLine().split(" ").map{it.toInt()}
    val q=LinkedList<Int>()
    q.offer(start)
    while (q.isNotEmpty())
    {
        val now=q.poll()
        for(i in arr[now])
        {
            if(dist[i.first]<dist[now]+i.second)
                dist[i.first]=dist[now]+i.second
            adegree[i.first]--
            if(adegree[i.first]==0)
                q.offer(i.first)
        }
    }
    val visited=Array(n+1){false}
    bw.write("${dist[end]}\n")
    //bw.flush()
    q.offer(end)
    visited[end]=true
    var answer=0
    while (q.isNotEmpty())
    {
        val now=q.poll()
        for(i in brr[now])
        {
            if((dist[now]-dist[i.first])==i.second)
            {
                if(visited[now])
                {
                    answer++
                    //println("왜 안되는거지")
                    visited[i.first]=true
                }
            }
            bdegree[i.first]--
            if(bdegree[i.first]==0)
                q.offer(i.first)
        }
    }
    bw.write("$answer")
    bw.flush()
}