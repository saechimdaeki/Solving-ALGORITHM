package boj14681kot

import java.util.*

private val dx= arrayOf(-2,-1,1,2,2,1,-1,-2)
private val dy= arrayOf(1,2,2,1,-1,-2,-2,-1)
private lateinit var checked:Array<Array<Int>>
private var t=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    t=br.readLine().toInt()
    for(i in 0 until t)
    {
        val n=br.readLine().toInt()
        checked=Array(n){Array(n){-1}}
        val (startx, starty)=br.readLine().split(" ").map { it->it.toInt() }
        val (endx,endy)=br.readLine().split(" ").map { it->it.toInt() }
        bw.write("${bfs(startx,starty,endx,endy,n)}\n")
    }
    bw.flush()
}
private fun bfs(startx:Int, starty:Int, endx:Int, endy:Int,n1:Int):Int{
    val q:Queue<Pair<Int,Int>> =LinkedList()
    q.offer(Pair(startx,starty))
    checked[startx][starty]=0
    while (q.isNotEmpty())
    {
        val (nowx, nowy)=q.poll()
        if(nowx==endx && nowy==endy)
            return checked[endx][endy]
        for(i in 0 until 8)
        {
            val nextx=dx[i]+nowx
            val nexty=dy[i]+nowy
            if(nextx in 0 until n1 && nexty in 0 until n1)
            {
                if(checked[nextx][nexty]==-1)
                {
                    q.offer(Pair(nextx,nexty))
                    checked[nextx][nexty]= checked[nowx][nowy]+1
                }
            }
        }
    }
    return 0

}