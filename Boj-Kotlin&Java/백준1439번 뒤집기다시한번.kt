package boj14681kot

import kotlin.math.min

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val s=br.readLine()
    var (zero , one)= intArrayOf(0,0)
    if(s[0]=='0')
        zero++
    else
        one++
    for(i in 1 until s.length)
    {
        if(s[i-1]!=s[i])
        {
            if(s[i]=='0')
                zero++
            else
                one++
        }
    }
    println(min(zero,one))
}