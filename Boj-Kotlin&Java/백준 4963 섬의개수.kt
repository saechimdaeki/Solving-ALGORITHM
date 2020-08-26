package boj14681kot

import java.util.*


private val dx= arrayOf(0,0,1,1,1,-1,-1,-1)
private val dy= arrayOf(1,-1,0,1,-1,0,1,-1)
private lateinit var arr:Array<Array<Int>>
private var cnt=0
private lateinit var checked:Array<Array<Boolean>>
private var w=0
private var h=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    while(true) {
      val input=br.readLine().split(" ")
        w=input[0].toInt()
        h=input[1].toInt()
        if(w==0 && h==0)
        break
        arr=Array(h){Array(w){0}}
        checked=Array(h){Array(w){false}}
        cnt=0
        for(i in 0 until h)
        {
            val input=br.readLine().split(" ")
            for(j in 0 until w)
                arr[i][j]=input[j].toInt()
        }
        for(i in 0 until h)
        {
            for (j in 0 until w)
            {
                if(arr[i][j]==1 && !checked[i][j])
                {
                    cnt++
                    bfs(i,j)
                }
            }
        }
        bw.write("${cnt}\n")
    }

    bw.flush()
}
private fun bfs(x:Int, y:Int)
{
    val q:Queue<Pair<Int, Int > > =LinkedList()
    q.offer(Pair(x,y))
    checked[x][y]=true
    while(q.isNotEmpty())
    {
        val(nowx,nowy)=q.poll()
        for( i in 0 until 8)
        {
            val nextx=dx[i]+nowx
            val nexty=dy[i]+nowy
            if(0<=nextx && nextx<h &&0<=nexty && nexty<w)
            {
                if(arr[nextx][nexty]==1 && !checked[nextx][nexty])
                {
                    q.offer(Pair(nextx,nexty))
                    checked[nextx][nexty]=true
                }
            }
        }
    }
}
