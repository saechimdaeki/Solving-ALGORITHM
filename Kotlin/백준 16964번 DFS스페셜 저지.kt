package boj14681kot

import kotlin.system.exitProcess

private lateinit var arr: Array<ArrayList<Int>>
private var dfs_susoon=ArrayList<Int>()
private lateinit var checked:Array<Boolean>
fun main(args:Array<String>)
{
    val br= System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=Array(n){ ArrayList<Int>() }
    checked=Array(n){false}
    val b=Array(n){0}
    val susoon=Array(n){0}
    for(i in 0 until n-1)
    {
        val (from , to) =br.readLine().split(" ").map { it->it.toInt()-1 }
        arr[from].add(to)
        arr[to].add(from)
    }
    val result=br.readLine().split(" ")

    for(i in 0 until n)
    {
       b[i]=result[i].toInt()-1
        susoon[b[i]]=i
    }
    for(i in 0 until n)
    {
        arr[i].sortBy { susoon[it] }
    }
    dfs(0)
    for(i in 0 until n)
    {
        if(dfs_susoon[i]!=b[i])
        {
            println(0)
            exitProcess(0)
        }
    }
    println(1)
}
private fun dfs(x:Int){
    if(checked[x])
        return
    dfs_susoon.add(x)
    checked[x]=true
    for(i in arr[x])
        dfs(i)
}