import java.util.*
import kotlin.math.max

private lateinit var arr:Array<Array<Int>>
private lateinit var checked:Array<Array<Boolean>>
private val dx= intArrayOf(1,-1,0,0)
private val dy= intArrayOf(0,0,1,-1)
private var globaln=0
private var globalm=0
private var answer=0
fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    arr = Array(n) { Array(m) { 0 } }
    checked = Array(n) { Array(m) { false } }
    globaln = n
    globalm = m
    for (i in 0 until n) {
        val input = br.readLine().split(" ").map { it.toInt() }
        for (j in input.indices)
            arr[i][j] = input[j]
    }
   loopwhile@ while (true)
    {
        var readyToAnswer=false
        for(i in 0 until n)
        checked[i].fill(element = false)
        var cnt=0
        loopfor@ for(i in 0 until n )
        {
            for( j in 0 until m)
            {
                if(arr[i][j]!=0 && !checked[i][j])
                {
                    cnt++
                    if(cnt==2)
                    {
                        readyToAnswer=true
                        break@loopfor
                    }
                    bfs(i,j)
                }
            }
        }
        if(readyToAnswer) {
            break@loopwhile
        }
        if(cnt==0)
        {
            answer=0
            break@loopwhile
        }
        oneYearLater()
        answer++
    }
    println(answer)
}
private fun bfs(x:Int,y:Int)
{
    val q=LinkedList<Pair<Int,Int>>()
    q.offer(Pair(x,y))
    checked[x][y]=true
    while (q.isNotEmpty())
    {
        val (nowx, nowy)=q.poll()
        for(i in 0 until 4)
        {
            val nextx=nowx+dx[i]
            val nexty=nowy+dy[i]
            if(nextx in 0 until globaln && nexty in 0 until globalm && arr[nextx][nexty]!=0 && !checked[nextx][nexty]  )
            {
                    checked[nextx][nexty] = true
                    q.offer(Pair(nextx, nexty))
            }
        }
    }
}
private fun oneYearLater() {
    var tmp = Array(globaln){Array(globalm){0}}
    for(i in 0 until globaln)
    {
        for(j in 0 until globalm)
            tmp[i][j]=arr[i][j]
    }
    for (i in 0 until globaln ) {
        for (j in 0 until globalm) {
            if (tmp[i][j] != 0) {
                var zeroCount = 0
                for (k in 0 until 4) {
                    val nexti = i + dx[k]
                    val nextj = j + dy[k]
                    if (tmp[nexti][nextj] == 0)
                        zeroCount++
                }
                arr[i][j]= max(tmp[i][j]-zeroCount,0)
            }
        }
    }
}