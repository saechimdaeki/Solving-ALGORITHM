package 백준

import java.util.*

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,k)=br.readLine().split(" ").map { it.toInt() }
    val q=LinkedList<Int>()
    for(i in 1..n)
        q.offer(i)
    bw.write("<")
    while (q.isNotEmpty()){
        for(i in 0 until k-1)
            q.offer(q.poll())
        if(q.size==1)
            bw.write("${q.poll()}")
        else
        bw.write("${q.poll()}, ")
    }
    bw.write(">")
    bw.flush()
}