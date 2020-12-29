package 백준

import java.util.*
import kotlin.system.exitProcess

private val arr=Array(10){""}
private val dx= intArrayOf(1,-1,0,0)
private val dy= intArrayOf(0,0,1,-1)
private val dist=Array(11){IntArray(11){-1}}
fun main() {
    val br=System.`in`.bufferedReader()
    var (sx,sy)= arrayOf(0,0)
    var (ex,ey)= arrayOf(0,0)
    for(i in 0 until 10){
        arr[i]=br.readLine()
    }
    for(i in 0 until 10){
        for(j in arr[i].indices){
            when {
                arr[i][j]=='B' -> {
                    sx=i
                    sy=j
                    dist[i][j]=0
                }
            }
            if(arr[i][j]=='L'){
                ex=i
                ey=j
            }
        }
    }
    val q=LinkedList<Pair<Int,Int>>()
    q.offer(Pair(sx,sy))
    while (q.isNotEmpty()){
        val (nowx,nowy)=q.poll()
        when {
            nowx==ex && nowy==ey -> {
                println("${dist[nowx][nowy]-1}")
                exitProcess(0)
            }
        }
        (0 until 4).forEach { i ->
            val (nextx,nexty)= arrayOf(nowx+dx[i],nowy+dy[i])
            when {
                nextx<0 || nextx>=10 || nexty<0 || nexty>=10 -> return@forEach
                arr[nextx][nexty] =='R' -> return@forEach
                dist[nextx][nexty]!=-1 -> return@forEach
                else -> {
                    dist[nextx][nexty] = dist[nowx][nowy] + 1
                    q.offer(Pair(nextx, nexty))
                }
            }
        }
    }
}