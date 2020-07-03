package boj14681kot

import kotlin.math.min

private var s=""
private var one=0
private var zero=0
fun main(args:Array<String>)
{
    val br= System.`in`.bufferedReader()
    s=br.readLine()
    if(s[0]=='0')
        zero++
    else
        one++
    for(i in 1 until s.length)
    {
        if(s[i]!=s[i-1])
        {
            if(s[i]=='0')
                zero++
            else
                one++
        }
    }
    println(min(zero,one))

}