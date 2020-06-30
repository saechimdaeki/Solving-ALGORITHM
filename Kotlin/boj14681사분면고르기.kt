package boj14681kot

import java.io.BufferedReader
import java.io.InputStreamReader


fun main(args:Array<String>)
{
    val br=BufferedReader(InputStreamReader(System.`in`))
    val a=Integer.parseInt(br.readLine())
    val b:Int=Integer.parseInt(br.readLine())
    if(a >0 && b>0)
    println(1)
    else if(a>0 && b<0)
        println(4)
    else if(a<0 && b>0)
        println(2)
    else
        println(3)
}