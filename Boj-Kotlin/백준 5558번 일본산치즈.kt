import java.util.*
import kotlin.system.exitProcess

private var mouseHealth=1
private lateinit var arr:Array<Array<Char>>
private lateinit var dist:Array<Array<Int>>
private val dx= intArrayOf(1,-1,0,0)
private val dy= intArrayOf(0,0,1,-1)
private var nowCheeseCnt=0
private var mousex=0
private var mousey=0
private var answer=0
fun main() {
    val br=System.`in`.bufferedReader()
    val (h,w,n)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(h+1){Array(w+1){' '}} //1,1 start

    nowCheeseCnt=n

    for(i in 1..h)
    {
        val input=br.readLine()
        for(j in 1..input.length) {
            arr[i][j] = input[j - 1]
            if(arr[i][j]=='S')
            {
                mousex=i
                mousey=j
            }
        }
    }
    for(i in 0 until n)
    {
        dist=Array(h+1){Array(w+1){-1}}
        bfs(mousex,mousey,h,w)
    }
    println(answer)
}
private fun bfs(x:Int,y:Int,h:Int,w:Int){
    val q=LinkedList<Triple<Int,Int,Int>>()
    q.offer(Triple(x,y,0))
    dist[x][y]=0
    while (q.isNotEmpty())
    {
        val (nowx,nowy,nowd)=q.poll()
        for(i in 0 until 4)
        {
            val (nx,ny)= intArrayOf(nowx+dx[i],nowy+dy[i])
            if(nx<1||nx>h||ny<1 || ny>w) continue
            if(dist[nx][ny]!=-1 || arr[nx][ny]=='X') continue
            if(arr[nx][ny] in '1'..'9') {
                if(mouseHealth>=arr[nx][ny]-'0')
                {
                    mouseHealth++
                    arr[nx][ny]='.'
                    answer+=(nowd+1)
                    mousex=nx
                    mousey=ny
                    return
                }
            }
            q.offer(Triple(nx,ny,nowd+1))
            dist[nx][ny]=dist[nowx][nowy]+1
        }
    }

}