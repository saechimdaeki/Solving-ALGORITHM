import java.util.*
import kotlin.collections.ArrayList

private var answer=0
fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    
    for(i in 0 until n)
    {
        val input=br.readLine()
        val list=ArrayList<Char>()
        list.add(input[0])
        var group=true
        loopfor@ for(i in 1 until  input.length)
        {
                if(input[i-1]!=input[i])
                {
                    if(list.contains(input[i]))
                    {
                        group=false
                        break@loopfor
                    }else
                        list.add(input[i])
                }
            }
        if(group)
            answer++
    }
    println(answer)

}