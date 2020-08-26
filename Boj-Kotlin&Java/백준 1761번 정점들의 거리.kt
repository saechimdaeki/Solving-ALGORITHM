import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:Array<ArrayList<Pair<Int,Int>>>
private lateinit var parent:Array<Int>
private lateinit var depth:Array<Int>
private lateinit var dist:Array<Int>
private lateinit var check:Array<Boolean>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    arr=Array(n+1){ArrayList<Pair<Int,Int>>()}
    parent=Array(n+1){0}
    depth=Array(n+1){0}
    dist=Array(n+1){0}
    check=Array(n+1){false}
    repeat(n-1){
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        arr[a].add(Pair(b,c))
        arr[b].add(Pair(a,c))
    }
    val q=LinkedList<Int>()
    q.offer(1)
    check[1]=true
    parent[1]=0
    dist[1]=0
    depth[1]=0
    while (q.isNotEmpty())
    {
        val cur=q.poll()
        for(i in arr[cur])
        {
            val tmp=i.first
            if(!check[tmp])
            {
                dist[tmp]=dist[cur]+i.second
                depth[tmp]=depth[cur]+1
                check[tmp]=true
                parent[tmp]=cur
                q.offer(tmp)
            }
        }
    }
    var m=br.readLine().toInt()
    while (m-->0)
    {
        var (a,b)=br.readLine().split(" ").map { it.toInt() }
        var answer=dist[a]+dist[b]
        if(depth[a]<depth[b])
        {
            val tmp=a
            a=b
            b=tmp
        }
        while (depth[a]!=depth[b])
            a=parent[a]
        while (a!=b)
        {
            a=parent[a]
            b=parent[b]
        }
        answer-=2*dist[a]
        bw.write("$answer\n")
    }
    bw.flush()

}