package boj14681kot

import java.util.*
import kotlin.collections.HashSet
import kotlin.system.exitProcess

private const val hangae=1000000001
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (s,t)=br.readLine().split(" ").map { it->it.toLong() }
    val longq:Queue<Long> =LinkedList()
    val stringq:Queue<String> = LinkedList()
    val checkset=HashSet<Long>()
    longq.offer(s)
    stringq.offer("")
    checkset.add(s)
    while(longq.isNotEmpty())
    {
        var tmp=longq.poll()
        var str=stringq.poll()
        if(tmp==t)
        {
            if(str.isEmpty())
                str="0"
            println(str)
            exitProcess(0)
        }
        /* 연산의 아스키 코드 순서는 '*', '+', '-', '/' 이다.주의 */
        if(tmp*tmp in 0 until hangae &&!checkset.contains(tmp*tmp))
        {
            longq.offer(tmp*tmp)
            stringq.offer("$str*")
            checkset.add(tmp*tmp)
        }
        if(tmp+tmp in 0 until hangae && !checkset.contains(tmp+tmp))
        {
            longq.offer(tmp+tmp)
            stringq.offer("$str+")
            checkset.add(tmp+tmp)
        }

        if(tmp-tmp in 0 until hangae && !checkset.contains(tmp-tmp))
        {
            longq.offer(tmp-tmp)
            stringq.offer("$str-")
            checkset.add(tmp-tmp)
        }
        if(tmp!=0L &&tmp/tmp in 0 until hangae && !checkset.contains(tmp/tmp))
        {
            longq.offer(tmp/tmp)
            stringq.offer("$str/")
            checkset.add(tmp/tmp)
        }
    }
    println(-1)
}