import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

private lateinit var arr:Array<ArrayList<Int>>
private lateinit var degree:Array<Int>
private lateinit var work:Array<Int>
private lateinit var d:Array<Int>
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=Array(n+1){ArrayList<Int>()}
    degree=Array(n+1){0}
    d=Array(n+1){0}
    work=Array(n+1){0}
    for(i in 1 .. n)
    {
        val input=br.readLine().split(" ").map { it.toInt() }
        work[i]=input[0]
        var cnt=input[1]
        for(j in 2 until input.size)
        {
            arr[input[j]].add(i)
            degree[i]++
        }
    }
    val q=LinkedList<Int>()
    for(i in 1..n)
    {
        if(degree[i]==0)
        {
            q.offer(i)
            d[i]=work[i]
        }
    }
    while (q.isNotEmpty())
    {
        val now=q.poll()
        for(i in arr[now])
        {
            degree[i]--
            if(d[i]<d[now]+work[i])
                d[i]=d[now]+work[i]
            if(degree[i]==0)
                q.offer(i)
        }
    }
    var answer=0
    for(i in 1..n)
        answer= max(answer,d[i])
    println(answer)
}
