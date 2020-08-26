package boj14681kot

import java.io.BufferedReader
import java.io.InputStreamReader

fun main()= with(BufferedReader(InputStreamReader(System.`in`)))
{
    val input=readLine().split(" ")
    val n=input[0].toInt()
    var k=input[1].toInt()
    var arr=ArrayList<Int>()
    var answer=0
    for(i in 0 until n)
        arr.add(readLine().toInt())
    arr.sortDescending()
    for( i in 0 until n)
    {
        answer+=k/arr[i]
        k%=arr[i]
    }
    println(answer)
}