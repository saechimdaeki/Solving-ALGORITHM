import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:Array<ArrayList<Pair<Int,Int>>>
private lateinit var dist:Array<Int>
private lateinit var check:Array<Boolean>
private lateinit var from:Array<Int>
private val stack=Stack<Int>()
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val m=br.readLine().toInt()
    arr=Array(n+1){ArrayList<Pair<Int,Int>>()}
    for(i in 0 until m)
    {
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        arr[a].add(Pair(b,c))
    }
    check=Array(n+1){false}
    dist=Array(n+1){1000000000}
    from=Array(n+1){0}
    val (start,end)=br.readLine().split(" ").map { it.toInt() }
    dist[start]=0
    from[start]=-1
    for(i in 0 until n-1)
    {
        var tmpm=1000000000+1
        var x=-1
        for(j in 1..n)
        {
            if(!check[j]&&tmpm>dist[j])
            {
                tmpm=dist[j]
                x=j
            }
        }
        check[x]=true

        for(tmp in arr[x])
        {
            if(dist[tmp.first]>dist[x]+tmp.second) {
                dist[tmp.first] = dist[x] + tmp.second
                from[tmp.first]=x
            }
        }
    }
    var x=end
    while (x!=-1)
    {
        stack.push(x)
        x=from[x]
        //println(x)
    }
    bw.write("${dist[end]}\n")
    bw.write("${stack.size}\n")
    while (stack.isNotEmpty())
        bw.write("${stack.pop()} ")
    bw.flush()

}