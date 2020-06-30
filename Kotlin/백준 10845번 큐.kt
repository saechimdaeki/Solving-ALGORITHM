package boj14681kot

import java.util.*
import java.util.Queue as Queue

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val queue:Queue<Int> = LinkedList<Int>()
    var tmp:Int?=0
    for(i in 0 until n step 1)
    {
        val string=br.readLine().split(" ")
        if(string[0].equals("push"))
        {
            queue.offer(string[1].toInt())
            tmp=string[1].toInt()
        }else if(string[0].equals("front"))
        {
            if(queue.isEmpty())
                bw.write("-1\n")
            else
                bw.write("${queue.peek()}\n")
        }
        else if(string[0].equals("size")){
            bw.write("${queue.size}\n")
        }else if(string[0].equals("empty"))
        {
            if(queue.isEmpty())
                bw.write("1\n")
            else
                bw.write("0\n")
        }else if(string[0].equals("back"))
        {
            if(queue.isEmpty())
                bw.write("-1\n")
            else
                bw.write("${tmp}\n")
        }else if(string[0].equals("pop"))
        {
            if(queue.isEmpty())
                bw.write("-1\n")
            else
                bw.write("${queue.poll()}\n")
        }
    }
    bw.flush()
}