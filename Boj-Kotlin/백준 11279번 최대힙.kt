import java.util.*

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val pq=PriorityQueue<Int>()
    for(i in 0 until n)
    {
        val input=br.readLine().toInt()
        if(input==0)
        {
            if(pq.isEmpty())
                bw.write("0\n")
            else
                bw.write("${-pq.poll()}\n")
        }else
        {
            pq.offer(-input)
        }
    }
    bw.flush()
}