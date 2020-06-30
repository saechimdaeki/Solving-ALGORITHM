package boj14681kot

import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.exitProcess

private lateinit var arr: Array<ArrayList<Int>>
private lateinit var bfsresult:Array<Int>
private lateinit var susoon:Array<Int>
private lateinit var checked:Array<Boolean>
private var q:Queue<Int> = LinkedList()
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n =br.readLine().toInt()
    arr=Array(n){ ArrayList<Int>()}
    bfsresult=Array(n){0}
    checked=Array(n){false}
    susoon=Array(n){0}
    for(i in 0 until n-1) {
        val (from, to) = br.readLine().split(" ").map { it -> it.toInt()-1 }
        arr[from].add(to)
        arr[to].add(from)
    }
    val result=br.readLine().split(" ")
    for(i in result.indices)
    {
        bfsresult[i]=result[i].toInt()-1
        susoon[bfsresult[i]]=i
    }
    for(i in 0 until n) {
        arr[i].sortBy { susoon[it] }
    }

    q.offer(0)
    checked[0]=true

    val bfslist=ArrayList<Any>()
    while(q.isNotEmpty())
    {
        val front=q.poll()
        bfslist.add(front)
        for(i in arr[front])
        {
            if(!checked[i])
            {
                checked[i]=true
                q.offer(i)
            }
        }
    }
    for(i in 0 until n)
    {
        if(bfslist[i]!= bfsresult[i])
        {
            println(0)
            exitProcess(0)
        }
    }
    println(1)
}