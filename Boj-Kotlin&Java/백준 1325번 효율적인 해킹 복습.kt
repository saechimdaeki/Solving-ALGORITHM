package 백준

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:Array<ArrayList<Int>>
private lateinit var visited:BooleanArray
private val answerlist= arrayListOf<Int>()
private var hacker=0
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n+1){ArrayList<Int>()}
    visited= BooleanArray(n+1)
    repeat(m){
        val (x,y)=br.readLine().split(" ").map { it.toInt() }
        arr[y].add(x)
    }
    for(i in 1..n){
        visited.fill(element = false)
        bfs(i)
    }
    answerlist.sort()
    for(i in answerlist)
        print("$i ")
}
private fun bfs(n:Int){
    val q=LinkedList<Int>()
    q.offer(n)
    visited[n]=true
    var cnt=0
    while (q.isNotEmpty()){
        val now=q.poll()
        for(i in arr[now]){
            if(visited[i]) continue
            q.offer(i)
            visited[i]=true
            cnt++
        }
    }
    if(hacker<cnt)
    {
        hacker=cnt
        answerlist.clear()
        answerlist.add(n)
    }else if(hacker==cnt)
        answerlist.add(n)
}