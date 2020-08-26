package boj14681kot

import java.math.BigInteger

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()

    var tmp=""
    val list=ArrayList<BigInteger>()
    for(i in 0 until n)
    {
        val input=br.readLine()
        for(j in input.indices)
        {
            if(input[j] in 'a'..'z' ) {
                if(j!=input.length-1)
                if(tmp.isNotEmpty()) {
                    list.add(tmp.toBigInteger())
                }
                tmp=""
                continue
            }
            tmp+=input[j]
            if(j==input.length-1&& input[j] !in 'a'..'z') {
                list.add(tmp.toBigInteger())
                tmp=""
            }
        }
    }
    list.sort()
    for(i in list)
        println(i)
}