import java.util.*
import kotlin.collections.HashMap


private val dx= intArrayOf(0,0,-1,1)
private val dy= intArrayOf(1,-1,0,0)

fun main() {
    val br=System.`in`.bufferedReader()
    var start=0
    for(i in 0 until 3)
    {
        val input=br.readLine().split(" ").map{it.toInt()}
        for(j in input.indices) {
            var tmp=input[j]
            if(tmp==0)
                tmp=9
            start=start*10 +tmp
        }
    }
    val q=LinkedList<Int>()
    val map=HashMap<Int,Int>()
    q.offer(start)
    map[start] = 0
    while (q.isNotEmpty())
    {
        val nowNumber=q.poll()
        val nowString=nowNumber.toString()
        val z=nowString.indexOf('9')
        val x=z/3
        val y=z%3
        for(i in 0 until 4)
        {
            val nx=x+dx[i]
            val ny=y+dy[i]
            if(nx in 0 until 3 && ny in 0 until 3)
            {
                val next = StringBuilder(nowString)
                val tmp=next[x*3+y]
                next.setCharAt(x*3+y,next[nx*3+ny])
                next.setCharAt(nx*3+ny,tmp)
                val number=next.toString().toInt()
                if(!map.containsKey(number))
                {
                    map[number] = map[nowNumber]!! +1
                    q.offer(number)
                }
            }
        }
    }
    if(map.containsKey(123456789))
        println(map[123456789])
    else
        println(-1)
}