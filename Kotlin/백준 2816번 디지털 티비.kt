package boj14681kot

import java.util.*

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    var wherekbs1=0
    var wherekbs2=0
    for(i in 0 until n)
    {
        val tmp=br.readLine()
        if(tmp=="KBS1")
            wherekbs1=i
        if(tmp=="KBS2")
            wherekbs2=i
    }
    if(wherekbs1>wherekbs2)
        wherekbs2++
    for(i in 0 until wherekbs1)
        print("1")
    for(i in 0 until wherekbs1)
        print("4")
    if(wherekbs2!=1)
    {
        for(i in 0 until wherekbs2)
            print("1")
        for(i in 1 until wherekbs2)
            print("4")
    }

}