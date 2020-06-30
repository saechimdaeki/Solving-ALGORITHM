package boj14681kot

import java.util.*


private var n=0
private lateinit var arr:Array<Array<Int>>
private lateinit var checked:Array<Array<Int>>
private var dx= arrayOf(-1,1,0,0)
private var dy= arrayOf(0,0,1,-1)
private var cnt=0

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    n=br.readLine().toInt()
    arr=Array(n+1){Array(n+1){0}}
    checked= Array(n+1){ Array(n+1){0} }
    for(i in 0 until n step 1) {
        val input = br.readLine()
        for (j in 0 until n step 1) {
            arr[i][j] = input[j] - '0'
        }
    }
    for(i in 0 until n)
    {
        for (j in 0 until n)
        {
            if(arr[i][j]==1 && checked[i][j]==0)
                bfs(i,j,++cnt)
        }
    }
    bw.write("$cnt\n")
    val answer=Array(cnt){0}
    for(i in 0 until n)
    {
        for(j in 0 until n)
            if(checked[i][j]!=0)
                answer[checked[i][j]-1]++
    }
    answer.sort()
    for(i in 0 until cnt)
        bw.write("${answer[i]}\n")
    bw.flush()
}
private fun bfs(x:Int, y:Int, cnt:Int)
{
    val q:Queue<Pair<Int, Int >> = LinkedList()
    q.offer(Pair(x,y))
    checked[x][y]=cnt
    while(q.isNotEmpty())
    {
        val (nowx, nowy) = q.poll()
        for(i in 0 until 8)
        {
            val nextx=dx[i]+nowx
            val nexty=dy[i]+nowy
            if(nextx in 0 until n && nexty in 0 until n)
            {
                if(arr[nextx][nexty]==1 && checked[nextx][nexty]==0){
                    q.offer(Pair(nextx,nexty))
                    checked[nextx][nexty]=cnt
                }
            }
        }
    }
}