import java.util.*

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var n=br.readLine().toInt()
    val leftpq=PriorityQueue<Int>() //최대힙
    val rightq=PriorityQueue<Int>() //최소힙
    while (n-- >0)
    {
        val x=br.readLine().toInt()
        if(leftpq.isEmpty()||rightq.isEmpty())
            leftpq.offer(-x)
        else{
            if(x<= -leftpq.peek())
                leftpq.offer(-x)
            else if(x>=rightq.peek())
                rightq.offer(x)
            else
                leftpq.offer(-x)
        }
        while (!(leftpq.size==rightq.size || leftpq.size==rightq.size+1) )
        {
            if(leftpq.size>rightq.size)
            {
                rightq.offer(-leftpq.poll())
            }else
                leftpq.offer(-rightq.poll())
        }
        bw.write("${-leftpq.peek()}\n")
    }
    bw.flush()
}