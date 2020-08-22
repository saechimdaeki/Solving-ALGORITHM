import java.util.*

private lateinit var arr:Array<Array<Int>>
private lateinit var d:Array<Array<Int>>
private val dx= intArrayOf(0,-1,0,1)
private val dy= intArrayOf(-1,0,1,0)
private val castleroom=Array(2501){0}
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (m,n)=br.readLine().split(" ")
            .map { it.toInt() }
    arr=Array(n){Array(m){0}}
    d=Array(n){Array(m){0} }
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ")
                .map { it.toInt() }
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    var rooms=0
    for(i in 0 until n)
    {
        for(j in 0 until m)
        {
            if(d[i][j]==0)
            {
                rooms++
                castleroom[rooms]=bfs(i,j,rooms,n,m)
            }
        }
    }
    bw.write("$rooms\n")
    var answer=0
    for(i in 1..rooms){
        if(answer<castleroom[i])
            answer=castleroom[i]
    }
    bw.write("$answer\n")
    answer=0
    for(i in 0 until n)
    {
        for(j in 0 until m)
        {
            val x=i
            val y =j
            for(k in 0 until 4)
            {
                val nx=x+dx[k]
                val ny=y+dy[k]
                if(nx<0 ||nx>=n || ny<0 ||ny>=m)
                    continue
                if(d[nx][ny]==d[x][y])
                    continue
                if((arr[x][y] and (1 shl k) >0 )){
                    if(answer<castleroom[d[x][y]]+ castleroom[d[nx][ny]])
                        answer=castleroom[d[x][y]]+ castleroom[d[nx][ny]]
                }
            }
        }
    }
    bw.write("$answer\n")
    bw.flush()
}
private fun bfs(sx:Int,sy:Int,rooms:Int,n:Int,m:Int):Int{
    val q=LinkedList<Pair<Int,Int>>()
    q.offer(Pair(sx,sy))
    d[sx][sy]=rooms
    var cnt=0
    while (q.isNotEmpty())
    {
        val (x,y)=q.poll()
        cnt++
        for(i in 0 until 4)
        {
            val nx=x+dx[i]
            val ny=y+dy[i]
            if(nx<0 ||nx>=n || ny<0 ||ny>=m)
                continue
            if(d[nx][ny]!=0)
                continue
            if((arr[x][y] and (1 shl i)) >0)
                continue
            q.offer(Pair(nx,ny))
            d[nx][ny]=rooms
        }
    }
    return cnt
}