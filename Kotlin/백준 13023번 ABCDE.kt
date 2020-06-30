package boj14681kot


import kotlin.collections.ArrayList
import kotlin.system.exitProcess

private lateinit var arr:Array<ArrayList<Int>>
private lateinit var checked:Array<Array<Boolean>>
private var n=0
private var m=0
private class struct(from:Int,to:Int){
    var from=0
    var to=0
    init {
        this.from=from
        this.to=to
    }
}
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val input=br.readLine().split(" ")
    n=input[0].toInt()
    m=input[1].toInt()
    arr= Array(n){(ArrayList<Int>())}
    checked= Array(n){ Array(n){false} }
    val edges=ArrayList<struct>()
    for(i in 0 until m)
    {
        val relation=br.readLine().split(" ")
        val from=relation[0].toInt()
        val to=relation[1].toInt()
        edges.add(struct(from,to))
        edges.add(struct(to,from))
        checked[from][to]=true
        checked[to][from]=true
        arr[from].add(to)
        arr[to].add(from)
    }
    m*=2
    for(i in 0 until m)
    {
        for (j in 0 until m)
        {
            val a=edges[i].from
            val b=edges[i].to
            val c=edges[j].from
            val d=edges[j].to
            if(a==b ||a==c || a==d ||b==c || b==d|| c==d)
                continue
            if(!checked[b][c])
                continue
            for(k in arr[d])
            {
               if(a==k || b==k ||c==k ||d==k)
                   continue
                println(1)
                exitProcess(0)
            }
        }
    }
    println(0)
}