package boj14681kot

import java.util.*

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var string=br.readLine()
    var stackleft= Stack<Char>()
    var stackright=Stack<Char>()
    for(i in string)
        stackleft.push(i)
    val n=br.readLine().toInt()
    for(i in 0 until n step 1)
    {
        var tmp=br.readLine()
        when(tmp[0])
        {
            'L' -> if(stackleft.isNotEmpty()){
                stackright.push(stackleft.pop())
            }
            'D' ->if(stackright.isNotEmpty()){
                stackleft.push(stackright.pop())
            }
            'B' -> if(stackleft.isNotEmpty()){
                stackleft.pop()
            }
            'P' -> stackleft.push(tmp[2])

        }

    }
    while(stackleft.isNotEmpty())
        stackright.push(stackleft.pop())
    var stringtmp:String=""
    while(stackright.isNotEmpty())
    {
        bw.write(stackright.pop().toString())
    }
    bw.flush()
}