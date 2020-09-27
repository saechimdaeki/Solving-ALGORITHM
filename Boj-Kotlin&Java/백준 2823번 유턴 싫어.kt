package 백준

import java.util.*
import kotlin.system.exitProcess

private lateinit var arr:Array<IntArray>
private lateinit var visited:Array<BooleanArray>
private val dx= intArrayOf(1,-1,0,0)
private val dy= intArrayOf(0,0,1,-1)
fun main() {
    val br=System.`in`.bufferedReader()
    val (r,c)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(r){IntArray(c)}
    visited=Array(r){ BooleanArray(c) }

    for(i in 0 until r){
        val input=br.readLine()
        for(j in input.indices) when {
            input[j] != 'X' -> arr[i][j]=0
            else -> {
                arr[i][j]=1
            }
        }
    }
    for(i in 0 until r){
        for(j in 0 until c){
            if(arr[i][j]==1) continue
            var cnt=0
            for(k in 0 until 4){
                val (nx,ny)= arrayOf(i+dx[k],j+dy[k])
                if(nx in 0 until r && ny in 0 until c && arr[nx][ny]==0){
                    cnt++
                }
            }
            if(cnt<=1) {
                println(1)
                exitProcess(0)
            }
        }
    }
    println(0)
}
