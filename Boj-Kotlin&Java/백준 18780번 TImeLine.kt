package 백준

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

private lateinit var arr:Array<ArrayList<Pair<Int,Int>>>
private lateinit var degree:IntArray
private lateinit var ref:IntArray
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m,c)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n+1){ ArrayList<Pair<Int,Int>>() } //백준컴파일러 버젼이 대체 뭐야.
    degree= IntArray(n+1)
    ref=br.readLine().split(" ").map { it.toInt() }.toIntArray()

    repeat(c){
        val (x,y,z)=br.readLine().split(" ").map { it.toInt() }
        arr[x].add(Pair(y,z))
        degree[y]++
    }
    val q=LinkedList<Int>()
    for(i in 1..n){
        if(degree[i]==0)
            q.offer(i)
    }
    while (q.isNotEmpty()){
        val now=q.poll()
        for(i in arr[now]){
            val (a,b)=i
            ref[a-1]= max(ref[a-1],ref[now-1]+b)
            degree[a]--
            if(degree[a]==0)
                q.offer(a)
        }
    }
    for(i in 0 until n){
        bw.write("${ref[i]}\n")
    }
    bw.flush()
}