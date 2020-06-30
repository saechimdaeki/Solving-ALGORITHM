package boj14681kot

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args:Array<String>)
{
    val br=BufferedReader(InputStreamReader(System.`in`))
    val n:Int=Integer.parseInt(br.readLine())
    val jeoul= br.readLine().split(' ').map{it.toInt()}.sorted()
    var sum:Int=1
    if(jeoul[0] != 1)
    {
        println(1)
        System.exit(0)
    }
    for(i in 1 until jeoul.size)
    {

        if(jeoul.get(i)>sum+1)
            break
        sum+=jeoul.get(i)
    }
    println(sum+1)
}