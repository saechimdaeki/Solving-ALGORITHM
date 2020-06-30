package boj14681kot

import kotlin.math.abs
private lateinit var broken:Array<Boolean>
private var n =0
private var m= 0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
     n=br.readLine().toInt()
     m=br.readLine().toInt()
     broken=Array(10){false}
    if(m>0) {
        val input=br.readLine().split(" ")
        for (i in 0 until m) {
            val tmp = input[i].toInt()
            broken[tmp] = true
        }
    }
    var answer=abs(n-100)
    for(i in 0 until 1000000)
    {
        val channel=i
        val len= ispossible(channel)
        if(len>0)
        {
            var press=abs(channel-n)
            if(answer>len+press)
                answer=len+press
        }
    }
    bw.write(answer.toString())
    bw.flush()
}
fun ispossible(x:Int):Int{
    if(x==0){
        return if(broken[0])
            0
        else
            1
    }
    var len=0
    var tmp=x
    while(tmp>0)
    {
        if(broken[tmp%10])
            return 0
        len++
        tmp/=10
    }
    return len
}