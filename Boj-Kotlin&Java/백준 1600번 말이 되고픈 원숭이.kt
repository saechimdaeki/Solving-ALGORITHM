import java.util.*

private val dx= intArrayOf(0,0,1,-1,-2,-1,1,2,-2,-1,1,2)
private val dy= intArrayOf(1,-1,0,0,1,2,2,1,-1,-2,-2,-1)
private val plus= intArrayOf(0,0,0,0,1,1,1,1,1,1,1,1)
private lateinit var arr:Array<Array<Int>>
private lateinit var dist:Array<Array<Array<Int>>>
fun main() {
    val br=System.`in`.bufferedReader()
    val k=br.readLine().toInt()
    val (w,h)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(h){Array(w){0}}
    dist=Array(h){Array(w){Array(30+1){-1}}}
    for(i in 0 until h)
    {
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    val q=LinkedList<Triple<Int,Int,Int>>()
    dist[0][0][0]=0
    q.offer(Triple(0,0,0))
    while(q.isNotEmpty())
    {
        val (x,y,z)=q.poll()
        for(i in 0 until 12)
        {
            val nextx=x+dx[i]
            val nexty=y+dy[i]
            val nextz=z+plus[i]
            if(nextx in 0 until h && nexty in 0 until w)
            {
                if(arr[nextx][nexty]==1)
                    continue
                if(nextz<=k)
                {
                    if(dist[nextx][nexty][nextz]==-1)
                    {
                        dist[nextx][nexty][nextz]=dist[x][y][z]+1
                        q.offer(Triple(nextx,nexty,nextz))
                    }
                }
            }
        }
    }
   var answer=-1
    // 최대 k번사용이지 k번안에 답이들어있는건 아닐수있으므로 k번이하라고 해석하는것.
    for(i in 0 until k+1)
    {
        if(dist[h-1][w-1][i]==-1)
            continue
        if(answer==-1|| answer>dist[h-1][w-1][i])
            answer=dist[h-1][w-1][i]
    }
    println(answer)

}