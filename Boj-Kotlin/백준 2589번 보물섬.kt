import java.util.*
import kotlin.math.max
/* 매번 리스트 추가하면 메모리초과뜸.*/
private lateinit var charr:Array<Array<Char>>
private lateinit var dist:Array<Array<Int>>
private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
private var answer=0
fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    charr=Array(n){Array(m){' '}}
    dist=Array(n){Array(m){-1}}
    for(i in 0 until n)
    {
        val input=br.readLine()
        for(j in input.indices)
            charr[i][j]=input[j]
    }
    for(i in 0 until n)
    {
        for(j in 0 until m)
        {
            if(charr[i][j]=='L')
                answer= max(answer,bfs(i,j,n,m))
        }
    }
    println(answer)
}
private fun bfs(x:Int,y:Int,n:Int,m:Int):Int{
    for(i in 0 until n)
        dist[i].fill(element = -1)
    val q=LinkedList<Pair<Int,Int>>()
    q.offer(Pair(x,y))
    dist[x][y]=0
    var ans=0
    while (q.isNotEmpty())
    {
        val (nowx,nowy)=q.poll()
        for(i in 0 until 4)
        {
            val nextx=nowx+dx[i]
            val nexty=nowy+dy[i]
            ans= max(ans,dist[nowx][nowy])
            if(nextx in 0 until n && nexty in 0 until m)
            {
                if(charr[nextx][nexty]=='L' && dist[nextx][nexty]==-1)
                {
                    q.offer(Pair(nextx,nexty))
                    dist[nextx][nexty]=dist[nowx][nowy]+1
                }
            }
        }
    }
    return ans
}