package boj14681kot

import java.util.*

private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
private var n=0
private lateinit var srr:Array<String>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    n=br.readLine().toInt()
    srr=Array(n){""}
    for(i in 0 until n)
        srr[i]=br.readLine()
    bw.write("${bfs(false)} ")
    bw.write("${bfs(true)}")
    bw.flush()
}
private fun bfs(blind:Boolean):Int{
    val checked=Array(n){Array(n){false} }
    var ans=0
    for(i in 0 until n)
    {
        for (j in 0 until n)
        {
            if(!checked[i][j])
            {
                ans++
                val q:Queue<Pair<Int,Int>> = LinkedList()
                q.offer(Pair(i,j))
                checked[i][j]=true
                while(q.isNotEmpty())
                {
                    val (x,y)= q.poll()
                    for(k in 0 until 4)
                    {
                        val nx=x+dx[k]
                        val ny=y+dy[k]
                        if(nx in 0 until n && ny in 0 until n)
                        {
                            if(checked[nx][ny])
                                continue
                            if(can(blind,srr[x][y],srr[nx][ny]))
                            {
                                checked[nx][ny]=true
                                q.offer(Pair(nx,ny))
                            }
                        }
                    }
                }
            }
        }
    }
    return ans
}
private fun can(blind:Boolean, from:Char, to:Char):Boolean{
    if(from==to)
        return true
    if(blind)
    {
        if(from=='R' && to=='G')
            return true
        if(from=='G' && to=='R')
            return true
    }
    return false
}