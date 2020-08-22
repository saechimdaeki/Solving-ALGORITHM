package boj14681kot

import java.io.BufferedReader
import java.util.*

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    for(i in 0 until n)
    {
        var boolean=true
        var string=br.readLine()
        var stack= Stack<Char>()
        for(i in string.indices)
        {
            if(string[i]=='(')
                stack.push(string[i])
            else{
                if(stack.empty())
                {
                    boolean=false
                }else
                stack.pop()
            }
        }
        if(stack.isNotEmpty())
            boolean=false
        if(boolean)
            bw.write("YES\n")
        else
            bw.write("NO\n")
    }
    bw.flush()
}