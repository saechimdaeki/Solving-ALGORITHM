package 백준

import kotlin.math.min

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toLong() }
    val arr= Array((n).toInt()){0L}
    for(i in 0 until n.toInt()){
        arr[i]=br.readLine().toLong()
    }
    arr.sort()
    var answer=Long.MAX_VALUE
    var (start,end)= arrayOf(0,1)
    while (start<n){
        if(end==n.toInt()) break
        if(arr[end]-arr[start]<m){
            end++
            continue
        }
        if(arr[end]-arr[start]==m){
            answer=m
            break
        }
        answer= min(answer,arr[end]-arr[start])
        start++
    }
    println(answer)
}