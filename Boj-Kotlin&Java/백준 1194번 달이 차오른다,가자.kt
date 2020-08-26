import java.util.*
import kotlin.system.exitProcess

private var startx=0
private var starty=0
private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
private lateinit var visited:Array<Array<Array<Boolean>>>
private lateinit var arr:Array<Array<Char>>
fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n){Array(m){' '}}
    visited=Array(64){Array(n){Array(m){false}}}

    for(i in 0 until n)
    {
        val input=br.readLine()
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    for(i in 0 until n) {
        for (j in 0 until m) {
            if (arr[i][j] == '0') {
                startx = i
                starty = j
            }
        }
    }
    val q=LinkedList<Pair<Pair<Int,Int>,Pair<Int,Int> >>()
    q.offer(Pair(Pair(startx,starty), Pair(0,0)))
    visited[0][startx][starty]=true
    while (q.isNotEmpty())
    {
        val tmp=q.poll()
        val (nowx,nowy)=tmp.first
        val (cnt,key)=tmp.second
        if(arr[nowx][nowy]=='1') {
           println("$cnt")
            exitProcess(0)
        }
        for(i in 0 until 4)
        {
            val nextx=nowx+dx[i]
            val nexty=nowy+dy[i]
            if(nextx in 0 until n && nexty in 0 until m && !visited[key][nextx][nexty] && arr[nextx][nexty]!='#')
            {
                if(arr[nextx][nexty]=='.' ||arr[nextx][nexty]=='0'||arr[nextx][nexty]=='1')
                {
                    visited[key][nextx][nexty]=true
                    q.offer(Pair(Pair(nextx,nexty),Pair(cnt+1,key)))
                }else if(arr[nextx][nexty] in 'a'..'f')
                {
                    var newkey= 1 shl (arr[nextx][nexty]-'a')
                    newkey=newkey or key
                    if(!visited[newkey][nextx][nexty])
                    {
                        visited[key][nextx][nexty]=true
                        visited[newkey][nextx][nexty]=true
                        q.offer(Pair(Pair(nextx,nexty),Pair(cnt+1,newkey)))
                    }
                }else if( arr[nextx][nexty] in 'A'..'F')
                {
                    var door= 1 shl (arr[nextx][nexty]-'A')
                    if((key and door)>0)
                    {
                        visited[key][nextx][nexty]=true
                        q.offer(Pair(Pair(nextx,nexty),Pair(cnt+1,key)))
                    }
                }
            }
        }
    }
    println(-1)

}
