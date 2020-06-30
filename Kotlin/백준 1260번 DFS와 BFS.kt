package boj14681kot

import java.util.*


private var n =0
private var m=0
private var v=0
private lateinit var checked:Array<Boolean>
private lateinit var arr:Array<Array<Int>>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val input=br.readLine().split(" ")
    n=input[0].toInt()
    m=input[1].toInt()
    v=input[2].toInt()
    checked=Array(n+1){false}
    arr=Array(n+1){Array(n+1){0}}
    for(i in 0 until m step 1)
    {
        val relation=br.readLine().split(" ")
        val from=relation[0].toInt()
        val to=relation[1].toInt()
        arr[from][to]=1
        arr[to][from]=1
    }
    dfs1(v)
    for (i in checked.indices)
        checked[i]=false
    println()
    bfs1(v)
}
private fun dfs1(start:Int){
    checked[start]=true
    print("$start ")
    for(i in 1..n)
    {
        if(arr[start][i]==1 && !checked[i])
            dfs1(i)
    }
}
private fun bfs1(start:Int)
{
    var queue:Queue<Int> = LinkedList()
    queue.offer(start)
    checked[start]=true
    while(queue.isNotEmpty())
    {
        val front=queue.poll()
        print("$front ")
        for(i in 1..n)
        {
            if(arr[front][i]==1 && !checked[i])
            {
                queue.offer(i)
                checked[i]=true
            }
        }
    }
}