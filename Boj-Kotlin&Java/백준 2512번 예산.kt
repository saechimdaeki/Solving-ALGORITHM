package 백준

import kotlin.math.min

private var m:Long=0
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map{it.toInt()}
    m=br.readLine().toLong()
    var left=0
    var right=arr.max()
    var answer=0
    var sum:Long=0
    while (left<=right!!){
        var mid=(left+right)/2
        sum=0
        for(i in arr.indices)
            sum+= min(arr[i],mid)
        if(sum<=m){
            answer=mid
           left=mid+1
        }else{
            right=mid-1
        }
    }
    println(answer)
}