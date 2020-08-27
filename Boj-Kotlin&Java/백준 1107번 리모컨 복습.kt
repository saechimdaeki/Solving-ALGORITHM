package 백준

import kotlin.math.abs
import kotlin.math.min

private val brokenarray=BooleanArray(10)
fun main() {
    val br=System.`in`.bufferedReader()
    var n=br.readLine().toInt()
    val bknum=br.readLine().toInt()
    if(bknum>0) {
        val broke = br.readLine().split(" ").map { it.toInt() }
        for(i in broke.indices)
            brokenarray[broke[i]]=true
    }
    var answer= abs(n-100)
    for(i in 0 until 1000000){
        val c=i
        val length=search(c, brokenarray)
        if(length>0){
            var press= abs(c-n)
            answer= min(answer,length+press)
        }
    }
    println(answer)
}
private fun search(c:Int,arr:BooleanArray):Int{
    if(c==0){
        return when{
            brokenarray[0]->0
            else -> 1
        }
    }
    var len=0
    var tmp=c
    while (tmp>0){
        when{
            brokenarray[tmp%10] -> return 0
            else ->{
                len++
                tmp/=10
            }
        }
    }
    return len
}