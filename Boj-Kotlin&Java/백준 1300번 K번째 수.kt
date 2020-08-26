package 백준

import kotlin.math.min
private var answer:Long=0
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val k=br.readLine().toInt()
    var left:Long=1
    var right:Long=k.toLong()
    var cnt=0
    while (left<=right){
        cnt=0
        val mid=(left+right)/2
        for(i in 1..n)
            cnt+= min((mid/i),n.toLong()).toInt()
        if(k<=cnt){
            answer=mid
            right=mid-1
        }else
            left=mid+1
    }
    println(answer)
}