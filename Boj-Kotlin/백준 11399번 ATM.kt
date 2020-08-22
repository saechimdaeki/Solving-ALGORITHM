package boj14681kot

import kotlin.collections.ArrayList

fun main(args:Array<String>)
{
    val arr=ArrayList<Int>()
    val arr2=ArrayList<Int>()
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val input=br.readLine().split(" ")
    for(i in 0 until n step 1)
        arr.add(input[i].toInt())
    arr.sort()
    var temp=0
    var sum=0
    for(i in arr)
    {
        temp+=i
        arr2.add(temp)
    }
    for(i in arr2)
        sum+=i
    println(sum)

}