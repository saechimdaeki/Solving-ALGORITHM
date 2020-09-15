import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:Array<ArrayList<Pair<Int,Int>>>
private lateinit var degree:IntArray
private lateinit var hangyeol:Array<IntArray>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val m=br.readLine().toInt()
    degree= IntArray(n+1)
    arr=Array(n+1){ArrayList<Pair<Int,Int>>()}
    hangyeol=Array(n+1){IntArray(n+1)}
    repeat(m){
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        arr[b].add(Pair(a,c))
        degree[a]++
    }
    val q=LinkedList<Int>()
    for(i in 1..n){
        if(degree[i]==0){
            q.offer(i)
            hangyeol[i][i]=1
        }
    }
    while (q.isNotEmpty()){
        val now=q.poll()
        for(i in arr[now]){
            for(j in 1..n)
                hangyeol[i.first][j]+= i.second*hangyeol[now][j]
            degree[i.first]--
            if(degree[i.first]==0)
                q.offer(i.first)

        }
    }
    for(i in 1..n){
        if(hangyeol[n][i]!=0)
            bw.write("$i ${hangyeol[n][i]}\n")
    }
    bw.flush()
}