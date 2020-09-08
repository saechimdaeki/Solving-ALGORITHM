package 백준

import java.util.*

fun main() {
    val t= readLine()!!.toInt()
    val bw=System.out.bufferedWriter()
    repeat(t){
        val n= readLine()!!.toInt()
        val arr= arrayListOf<Int>()
        for(i in 0 until n/10+1)
        {
            val list= readLine()!!.split(" ").map { it.toInt() }
            for(j in list.indices)
                arr.add(list[j])
        }
        val pqMin=PriorityQueue<Int>()
        val pqMax=PriorityQueue<Int>()
        var cnt=0
        bw.write("${(n+1)/2}\n")
        for(i in arr.indices){
            if(pqMin.size==pqMax.size)
                pqMax.offer(-arr[i])
            else
                pqMin.offer(arr[i])
            if(pqMin.isNotEmpty() && pqMax.isNotEmpty() && pqMin.peek()< -pqMax.peek()){
                val a=-pqMax.poll()
                val b=pqMin.poll()
                pqMin.offer(a)
                pqMax.offer(-b)
            }
            if(i%2==0){
                bw.write("${-pqMax.peek()} ")
                cnt++
                if(cnt%10==0)
                    bw.write("\n")
            }
        }
        bw.write("\n")
    }
    bw.flush()
}