package boj14681kot

import java.util.*


private lateinit var arr:Array<Array<Char>>
private val dx= intArrayOf(1,-1,0,0)
private val dy= intArrayOf(0,0,1,-1)
private lateinit var mool:Array<Array<Int>>
private lateinit var dist:Array<Array<Int>>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (r,c)=br.readLine().split(" ").map { it->it.toInt() }
    arr=Array(r){Array(c){' '}}
    for(i in 0 until r)
    {
        val input=br.readLine()
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    mool=Array(r){Array(c){-1}}
    dist=Array(r){Array(c){-1}}
    val q:Queue<Pair<Int,Int>> = LinkedList()
    var (startx,starty,endx,endy)= intArrayOf(0,0,0,0)
    for(i in 0 until r)
    {
        for( j in 0 until c)
        {
            if(arr[i][j]=='*')
            {
                q.offer(Pair(i,j))
                mool[i][j]=0
            }else if(arr[i][j]=='S')
            {
                startx=i
                starty=j
            }
            else if(arr[i][j]=='D')
            {
                endx=i
                endy=j
            }
        }
    }
    while(q.isNotEmpty())
    {
        val (x,y)=q.poll()
        for(i in 0 until 4)
        {
            val nx=x+dx[i]
            val ny=y+dy[i]
            if(nx<0 || nx>=r || ny<0 ||ny>=c)
                continue
            if(mool[nx][ny]!=-1)
                continue
            if(arr[nx][ny]=='X' ||arr[nx][ny]=='D')
                continue
            mool[nx][ny]=mool[x][y]+1
            q.offer(Pair(nx,ny))
        }
    }
    q.offer(Pair(startx,starty))
    dist[startx][starty]=0
    while(q.isNotEmpty())
    {
        val (x,y)=q.poll()
        for(i in 0 until 4)
        {
            val nx=x+dx[i]
            val ny=y+dy[i]
            if(nx<0 ||nx>=r || ny<0 ||ny>=c)
                continue
            if(dist[nx][ny]!=-1)
                continue
            if(arr[nx][ny]=='X')
                continue
            if(mool[nx][ny]!= -1 && dist[x][y]+1 >= mool[nx][ny])
                continue
            dist[nx][ny]=dist[x][y]+1
            q.offer(Pair(nx,ny))
        }
    }
    if(dist[endx][endy]==-1)
        println("KAKTUS")
    else
        println("${dist[endx][endy]}")

}