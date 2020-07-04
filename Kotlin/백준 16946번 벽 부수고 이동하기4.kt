package boj14681kot

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
private val list=ArrayList<Int>()
private lateinit var arr:Array<Array<Int>>
private lateinit var check:Array<Array<Boolean>>
private lateinit var group:Array<Array<Int>>
private var n1=0
private var m1=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n , m)=br.readLine().split(" ").map { it->it.toInt() }
    n1=n
    m1=m
    arr=Array(n){Array(m){0}}
    check=Array(n){Array(m){false}}
    group=Array(n){Array(m){-1}}
    for(i in 0 until n)
    {
        val input=br.readLine()
        for(j in input.indices)
            arr[i][j]=input[j]-'0'
    }
    for(i in 0 until n)
    {
        for(j in 0 until m)
        {
            if(arr[i][j]==0 && !check[i][j])
                bfs(i,j)
        }
    }
    for(i in 0 until n)
    {
        for( j in 0 until m)
        {
            if(arr[i][j]==0)
                print(0)
            else{
                val set:HashSet<Int> = HashSet()
                for(k in 0 until 4)
                {
                    val x=i+dx[k]
                    val y=j+dy[k]
                    if(x in 0 until n && y in 0 until m)
                    {
                        if(arr[x][y]==0)
                            set.add(group[x][y])
                    }
                }
                var answer=1
                for(k in set)
                    answer+=list[k]
                print(answer%10)
            }
        }
        println()
    }
}
private fun bfs(x:Int,y:Int)
{
    var g = list.size
    val q:Queue<Int> = LinkedList()
    q.offer(x)
    q.offer(y)
    check[x][y]=true
    group[x][y]=g
    var cnt=1
    while(q.isNotEmpty())
    {
        var x=q.poll()
        var y=q.poll()
        for(i in 0 until 4)
        {
            var nx=x+dx[i]
            var ny=y+dy[i]
            if(nx in 0 until n1 && ny in 0 until m1)
            {
                if(arr[nx][ny]==0 && !check[nx][ny])
                {
                    q.offer(nx)
                    q.offer(ny)
                    check[nx][ny]=true
                    group[nx][ny]=g
                    cnt++
                }
            }
        }
    }
    list.add(cnt)
}