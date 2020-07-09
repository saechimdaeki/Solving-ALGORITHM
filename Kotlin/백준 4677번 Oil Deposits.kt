package boj14681kot

import java.util.*

private val dx= intArrayOf(-1,0,1,-1,1,-1,0,1)
private val dy= intArrayOf(1,1,1,0,0,-1,-1,-1)
private lateinit var arr:Array<Array<Int>>
private lateinit var checked:Array<Array<Boolean>>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    while (true)
    {
        var answer=0
        val (n,m)=br.readLine().split(" ").map { it.toInt() }
        if(n==0 && m==0)
            break
        arr=Array(n){Array(m){0}}
        checked=Array(n){Array(m){false}}
        for(i in 0 until n)
        {
            val input=br.readLine()
            for(j in input.indices)
            {
                if(input[j]=='@')
                    arr[i][j]=1
                else if(input[j]=='*')
                    arr[i][j]=2
            }
        }
        for(i in 0 until n)
        {
            for(j in 0 until m)
            {
                if(arr[i][j]==1 && !checked[i][j]) {
                    gobfs(i, j,n,m)
                    answer++
                }
            }
        }
        bw.write("$answer \n")
    }
    bw.flush()
}
private fun gobfs(x:Int,y:Int,n1:Int,m1:Int)
{
    val q=LinkedList<Pair<Int,Int>>()
    q.offer(Pair(x,y))
    checked[x][y]=true
    while(q.isNotEmpty())
    {
        val (nowx,nowy)=q.poll()
        for(i in 0 until 8)
        {
            val nextx=nowx+dx[i]
            val nexty=nowy+dy[i]
            if(nextx in 0 until n1 && nexty in 0 until m1 )
            {
                if(arr[nextx][nexty]==1 && !checked[nextx][nexty])
                {
                    q.offer(Pair(nextx,nexty))
                    checked[nextx][nexty]=true
                }
            }
        }
    }
}