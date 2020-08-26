import java.util.*

private lateinit var arr:Array<Array<Int>>
private lateinit var dist:Array<Array<Int>>
private lateinit var s:Array<Array<Int>>
private val dx= intArrayOf(-1,1,0,0)
private val dy= intArrayOf(0,0,1,-1)
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map{it.toInt()}
    arr=Array(n+1){Array(m+1){0}}
    dist=Array(n+1){Array(m+1){-1}}
    s=Array(n+1){Array(m+1){0}}
    for(i in 1 .. n)
    {
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
            arr[i][j+1]=input[j]
    }
    val list=br.readLine().split(" ").map{it.toInt()}
    val h=list[0]
    val w=list[1]
    val x1=list[2]
    val y1=list[3]
    val x2=list[4]
    val y2=list[5]
    for(i in 1..n)
    {
        for(j in 1..m)
        {
            s[i][j]=s[i-1][j]+s[i][j-1]-s[i-1][j-1]+arr[i][j]
        }
    }
    val q=LinkedList<Pair<Int,Int>>()
    q.offer(Pair(x1,y1))
    dist[x1][y1]=0
    while (q.isNotEmpty())
    {
        val (x,y)=q.poll()
        for(i in 0 until 4)
        {
            val nextx=x+dx[i]
            val nexty=y+dy[i]
            if(!(1 > nextx || nextx+h-1 > n || 1 > nexty || (nexty+w).minus(1) > m))
            {
                if(sum(nextx,nexty,nextx+h-1,nexty+w-1)==0)
                {
                    if(dist[nextx][nexty]==-1)
                    {
                        q.offer(Pair(nextx,nexty))
                        dist[nextx][nexty]=dist[x][y]+1
                    }
                }
            }
        }
    }
    println(dist[x2][y2])
}
private fun sum(x1:Int,y1:Int,x2:Int,y2:Int):Int{
    return s[x2][y2]-s[x1-1][y2]-s[x2][y1-1]+s[x1-1][y1-1]
}