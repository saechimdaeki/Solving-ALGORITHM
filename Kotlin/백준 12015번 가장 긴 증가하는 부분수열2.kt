package boj14681kot

import kotlin.math.max
private lateinit var arr:IntArray
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var answer=0
    for(i in arr.indices)
    {
        val tmp=arr[i]
        var compare= kotlinbound(answer,tmp)
        arr[compare]=tmp
        if(answer==compare)
            answer++
    }
    println(answer)
}
private fun kotlinbound(n:Int,key:Int):Int{
    var left=0
    var right=n
    while(left<right)
    {
        var mid=(left+right)/2
        if(key<=arr[mid])
            right=mid
        else
            left=mid+1
    }
    return left
}