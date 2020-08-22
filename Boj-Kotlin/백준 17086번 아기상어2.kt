import java.util.*
import kotlin.collections.ArrayList

private val dx= intArrayOf(0,0,1,-1,1,1,-1,-1)
private val dy= intArrayOf(1,-1,0,0,1,-1,1,-1)
private lateinit var arr:Array<Array<Int>>
private val arrayList=ArrayList<Int>()
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n){Array(m){0}}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
        {
            arr[i][j]=input[j]
        }
    }
    for(i in 0 until n)
    {
        for(j in 0 until m)
        {
            if(arr[i][j]==0)
            {
                arrayList.add(bfs(i,j,n,m))
            }
        }
    }
    println(arrayList.max())
}
private fun bfs(x:Int,y:Int,n:Int,m:Int):Int{
    val dist=Array(n){Array(m){-1}}
    val q=LinkedList<Pair<Int,Int>>()
    q.offer(Pair(x,y))
    dist[x][y]=0
    while (q.isNotEmpty())
    {
        val (nowx,nowy)=q.poll()
        for(i in 0 until 8)
        {
            val nextx=nowx+dx[i]
            val nexty=nowy+dy[i]
            if(nextx in 0 until n && nexty in 0 until m)
            {
                if(dist[nextx][nexty]==-1)
                {
                    if(arr[nextx][nexty]==1)
                        return dist[nowx][nowy]+1
                    else
                    {
                        q.offer(Pair(nextx,nexty))
                        dist[nextx][nexty]=dist[nowx][nowy]+1
                    }
                }
            }
        }
    }
    return 0

}