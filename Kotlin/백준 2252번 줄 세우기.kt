import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:Array<ArrayList<Int>>
private lateinit var inDegree:Array<Int>
private  val bw=System.out.bufferedWriter()
fun main() {
    val br=System.`in`.bufferedReader()

    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n+1){ ArrayList<Int>() }
    inDegree=Array(n+1){0}
    for(i in 0 until m)
    {
        val (a,b)=br.readLine().split(" ").map { it.toInt() }
        arr[a].add(b)
        inDegree[b]++
    }
    gobfs(n)
    bw.flush()
}
private fun gobfs(n:Int)
{
    val q=LinkedList<Int>()
    for(i in 1..n)
    {
        if(inDegree[i]==0)
            q.offer(i)
    }
    while (q.isNotEmpty())
    {
        val now=q.poll()
        bw.write("$now ")
        for(i in arr[now])
        {
            inDegree[i]--
            if(inDegree[i]==0)
                q.offer(i)
        }
    }
}