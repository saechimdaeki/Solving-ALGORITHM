package 백준

import kotlin.math.max

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,k)=br.readLine().split(" ").map { it.toInt() }
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var sum=0
    for(i in 0 until k)
        sum+=arr[i]
    var answer=sum
    for(i in k until n){
        sum-=arr[i-k]
        sum+=arr[i]
        answer= max(answer,sum)
    }
    println(answer)
}