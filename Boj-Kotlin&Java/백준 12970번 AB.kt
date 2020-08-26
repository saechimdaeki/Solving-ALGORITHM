package boj14681kot

import kotlin.math.min
import kotlin.system.exitProcess

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    var (n,k)=br.readLine().split(" ").map { it.toInt() }
    for(i in 0..n)
    {
        var b= n-i
        if(i*b<k)
            continue
        val cnt=Array(b+1){0}
        for(j in 0 until i)
        {
            val x= min(b,k)
            cnt[x]++
            k-=x
        }
        for(j in b downTo 0)
        {
            for(z in 0 until cnt[j])
                print("A")
            if(j>0)
                print("B")
        }
        exitProcess(0)
    }
    println(-1)
}