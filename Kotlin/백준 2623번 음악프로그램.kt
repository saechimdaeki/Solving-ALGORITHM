import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.exitProcess

private lateinit var arr:Array<ArrayList<Int>>
private lateinit var degree:Array<Int>
private val answerlist= arrayListOf<Int>()
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var (n,m)=br.readLine().split(" ").map{it.toInt()}
    arr=Array(n+1){ArrayList<Int>()}
    degree=Array(n+1){0}
    repeat(m){
        val input=br.readLine().split(" ").map { it.toInt() }
        val tmp=input.slice(1 until input.size)


        for(i in 0 until input[0]-1)
        {
            arr[tmp[i]].add(tmp[i+1])
            degree[tmp[i+1]]++
        }
    }
    val q=LinkedList<Int>()
    for(i in 1..n)
    {
        if(degree[i]==0) {
            q.offer(i)
        }
    }
    while (q.isNotEmpty())
    {
        val now=q.poll()
        answerlist.add(now)
        for(i in arr[now])
        {
            degree[i]--
            if(degree[i]==0)
                q.offer(i)
        }
    }
    if(answerlist.size==n)
    {
        for(i in answerlist)
            bw.write("$i\n")
        bw.flush()
        exitProcess(0)
    }
    println(0)

}