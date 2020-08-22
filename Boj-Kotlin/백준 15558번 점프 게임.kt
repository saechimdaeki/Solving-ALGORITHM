import java.util.*

private lateinit var dist:Array<Array<Int>>
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,k)=br.readLine().split(" ").map { it.toInt() }
    dist=Array(2){Array(n){-1}}
    val arr=Array(2){" "}
    for(i in 0 until 2)
        arr[i]=br.readLine()
    val q=LinkedList<Pair<Int,Int>>()
    q.offer(Pair(0,0))
    dist[0][0]=0
    val dir= arrayOf(arrayOf(0,1), arrayOf(0,-1), arrayOf(1,k))
    var check=false
    whleloop@while (q.isNotEmpty())
    {
        val (x,y)=q.poll()
        for(i in dir)
        {
            val dx=i[0]
            val dy=i[1]
            val nx=(x+dx)%2
            val ny=y+dy
            if(ny>=n){
                check=true
                break@whleloop
            }
            if(ny<0) continue
            if(dist[nx][ny]!=-1)
                continue
            if(arr[nx][ny]=='0')
                continue
            if(ny<dist[x][y]+1)
                continue
            dist[nx][ny]=dist[x][y]+1
            q.offer(Pair(nx,ny))
        }
    }
    println(if (check) "1" else "0")
}