package 백준

import kotlin.math.max
import kotlin.math.min

private val dx= intArrayOf(1,0)
private val dy= intArrayOf(0,1)
private lateinit var arr:Array<Array<String>>
private var maxi=Int.MIN_VALUE
private var mini=Int.MAX_VALUE
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    arr=Array(n){Array(n){""}}
    for(i in 0 until n){
        val input=br.readLine().split(" ")
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    dfs(0,0,arr[0][0].toInt(),arr[0][0],n)
    println("$maxi $mini")
}
private fun dfs(x:Int,y:Int , now:Int, info:String,n:Int){
    for(i in 0 until 2){
        val nx=x+dx[i]
        val ny=y+dy[i]
        if(nx in 0 until n && ny in 0 until n){
            when {
                arr[nx][ny]=="+" -> dfs(nx,ny,now,"+",n)
                arr[nx][ny]=="-" -> dfs(nx,ny,now,"-",n)
                arr[nx][ny]=="*" -> dfs(nx,ny,now,"*",n)
                else -> {
                    var temp=0
                    when (info) {
                        "+" -> temp=now+(arr[nx][ny].toInt())
                        "-" -> temp=now-(arr[nx][ny].toInt())
                        "*" -> temp=now*(arr[nx][ny].toInt())
                    }
                    if(nx==n-1 && ny==n-1){
                        maxi= max(maxi,temp)
                        mini= min(mini,temp)
                        return
                    }
                    dfs(nx,ny,temp,arr[nx][ny],n)
                }
            }
        }
    }
}