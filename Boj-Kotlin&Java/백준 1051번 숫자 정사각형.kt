package 백준

import kotlin.math.max
import kotlin.math.min

private lateinit var arr:Array<IntArray>

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n){IntArray(m)}
    for(i in 0 until n){
        val input=br.readLine()
        for(j in input.indices){
            arr[i][j]=input[j]-'0'
        }
    }
    var answer=1
    for(i in 0 until n){
        for(j in 0 until m){
            for(k in 1 until min(n,m)){
                if(i+k <n && j+k <m && arr[i+k][j]==arr[i][j] && arr[i+k][j+k]==arr[i][j]
                        && arr[i][j+k]==arr[i][j])
                    answer= max(answer,k+1)
            }
        }
    }
    println(answer*answer)
}