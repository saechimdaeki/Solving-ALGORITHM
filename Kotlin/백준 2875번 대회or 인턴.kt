package boj14681kot

import kotlin.math.min

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n,m,k)=br.readLine().split(" ").map { it.toInt() }
    //여 남 인원수
    var answer= min((n+m-k)/3,n/2)
    println(min(answer,m))
}