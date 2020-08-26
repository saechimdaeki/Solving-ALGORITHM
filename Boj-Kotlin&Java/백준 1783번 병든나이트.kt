package boj14681kot

import kotlin.math.min

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    if(n==1)
        println(1)
    else if (n==2)
        println(min(4,(m+1)/2))
    else if(n>=3)
    {
        if(m>=7)
            println(m-2)
        else
            println(min(4,m))
    }
}