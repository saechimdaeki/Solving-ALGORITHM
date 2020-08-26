package boj14681kot

import java.util.*

private lateinit var arr:Array<Array<Int>>
private lateinit var checked:Array<Boolean>
private var cnt=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map {it->it.toInt() }
    arr=Array(n+1){Array(n+1){0}}
    checked=Array(n+1){false}
    for(i in 0 until m)
    {
        val (to , from)=br.readLine().split(" ").map { it->it.toInt() }
        arr[to][from]=1
        arr[from][to]=1
    }
    for(i in 1 ..n)
    {
        if(!checked[i])
            bfs(i,n)
    }
    print(cnt)
}
private fun bfs(start :Int, n1:Int)
{
    cnt++
    val queue:Queue<Int> = LinkedList()
    checked[start]=true
    queue.offer(start)
    while(queue.isNotEmpty())
    {
        val front=queue.poll()
        for(i in 1..n1)
        {
            if(arr[front][i]==1 &&!checked[i])
            {
                checked[i]=true
                queue.offer(i)
            }
        }
    }
}