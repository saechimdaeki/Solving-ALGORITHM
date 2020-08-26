package boj14681kot

import kotlin.math.min

private lateinit var arr:Array<Int>
private var answer=Int.MAX_VALUE
private var n1=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it->it.toInt() }
    n1=n
    arr=Array(m){0}
    for(i in 0 until m)
        arr[i]=br.readLine().toInt()
    var left=1
    var right=arr.max()
    while(left<=right!!)
    {
        var mid=(left+right)/2
        if(check(mid))
        {
            answer= min(answer,mid)
            right=mid-1
        }else
            left=mid+1
    }
    println(answer)
}
private fun check(mid:Int):Boolean{
    var cnt=0
    for(i in arr.indices)
    {
        cnt+=(arr[i]/mid)
        if(arr[i]%mid>0)
            cnt++
    }
    return n1>=cnt
}