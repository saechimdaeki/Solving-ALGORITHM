package boj14681kot

import kotlin.system.exitProcess
 /* 배워갑니다 .. */
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    var s=br.readLine()
    val answer=s.replace("XXXX","AAAA").replace("XX","BB")
    if("X" in answer)
    {
        println(-1)
        exitProcess(0)
    }
    println(answer)
}