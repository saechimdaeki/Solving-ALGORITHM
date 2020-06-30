package boj14681kot

import java.util.*

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var tmp=br.readLine().split(" ")
    var queue:Queue<Int> = LinkedList()
    val n=tmp[0].toInt()
    val k=tmp[1].toInt()
    for(i in 1..n)
        queue.offer(i)
    bw.write("<")
    while(queue.isNotEmpty())
    {
        for(i in 1 until k)
            queue.offer(queue.poll())
        if(queue.size==1)
            bw.write("${queue.poll()}>")
        else
            bw.write("${queue.poll()}, ")
    }
    bw.flush()
}