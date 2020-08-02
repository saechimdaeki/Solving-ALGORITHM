import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:Array<ArrayList<Pair<Int,Int>>>
private const val infi=1000000000;
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m,k)=br.readLine().split(" ").map{it.toInt()}
    arr=Array(n+1){ ArrayList<Pair<Int,Int>>() }
    repeat(m){
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        arr[a].add(Pair(b,c))
    }
    val dist= Array(n+1){PriorityQueue<Int>()}
    val cmp=Compare()
    for(i in 1..n)
        dist[i]= PriorityQueue(1,cmp)
    dist[1].offer(0)
    val q=PriorityQueue<node1854>()
    q.offer(node1854(1,0))
    while (q.isNotEmpty())
    {
        val (to,cost)=q.poll()
        for(i in arr[to])
        {
            val (ato,acost)= intArrayOf(i.first,i.second)
            if(dist[ato].size<k ||dist[ato].peek()>cost+acost)
            {
                if(dist[ato].size==k)
                    dist[ato].poll()
                dist[ato].offer(cost+acost)
                q.offer(node1854(ato,cost+acost))
            }
        }
    }
    for(i in 1..n)
    {
        if(dist[i].size!=k)
            bw.write("-1\n")
        else
            bw.write("${dist[i].peek()}\n")
    }
    bw.flush()

}
private data class node1854(var to:Int, var cost:Int):Comparable<node1854>{
    override fun compareTo(other: node1854): Int {
        return if (cost < other.cost) {
            -1
        } else if (cost == other.cost) {
            if (to < other.to) -1 else if (to > other.to) 1 else 0
        } else {
            1
        }
    }
}
private class Compare : Comparator<Int> {
    override fun compare(one: Int, two: Int): Int {
        return two.compareTo(one)
    }
}