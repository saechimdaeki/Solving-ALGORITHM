package 백준

import kotlin.math.max

fun main() {
    val br=System.`in`.bufferedReader()
    var (n,k)=br.readLine().split(" ").map { it.toInt() }
    val arr= Array(1000001){0}
    repeat(n){
        val (a,b)=br.readLine().split(" ").map { it.toInt() }
        arr[b]=a
    }
    k=k*2+1
    var sum=0
    var answer=-1
    for(i in 0 until 1000001){
        if(i>=k) sum-=arr[i-k]
        sum+=arr[i]
        answer= max(answer,sum)
    }
    println(answer)
}