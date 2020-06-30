package boj14681kot

import java.lang.StringBuilder
import java.util.*

fun main(args:Array<String>)
{
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var n=br.readLine().toInt()
    for(i in 0 until  n)
    {
        val s=br.readLine()
        var stack=Stack<Char>()
        var sb=StringBuilder()
        for(j in s.indices)
        {
            if(s[j]==' '|| s[j]=='\n')
            {
                while(stack.isNotEmpty()){
                    sb.append(stack.pop())
                }
                sb.append(s[j])
            }else if(j==s.length-1){
                stack.push(s[s.length-1])
                while(stack.isNotEmpty())
                    sb.append(stack.pop())
            }
            else{
                stack.push(s[j])
            }
        }
        bw.write(sb.toString()+'\n')
    }
    bw.flush()
}