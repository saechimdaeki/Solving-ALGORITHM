package boj14681kot

import kotlin.math.max

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    var arrayList=ArrayList<Int>()
    var dp=Array(1001){0}
    arrayList.add(0)
    val tmp=br.readLine().split(" ")
    for(i in tmp.indices)
        arrayList.add(tmp[i].toInt())
    for(i in 1..n)
    {
        for(j in 1..i)
        {
            dp[i]= max(dp[i],dp[i-j]+ arrayList[j])
        }
    }
    println(dp[n])
}