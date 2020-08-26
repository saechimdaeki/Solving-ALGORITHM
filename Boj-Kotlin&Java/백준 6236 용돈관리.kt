package boj14681kot

import java.io.BufferedReader
import java.io.InputStreamReader

var input2136:List<Int> = listOf()
var sum2136:Int=0
var answer2136=0
var arraylist2136:ArrayList<Int> = ArrayList()
fun main(args:Array<String>)
{

    val br=BufferedReader(InputStreamReader(System.`in`))
    input2136 =br.readLine().split(" ")
            .map{it.toInt()}
    for(i  in 0 until input2136[0])
    {
        arraylist2136.add(Integer.parseInt(br.readLine()))
        sum2136 = sum2136.plus(arraylist2136.get(i))
    }
    var left=1
    var right= sum2136
    while (left<=right)
    {
        var mid=(left+right)/2
        if(possible(mid))
        {
            answer2136=mid
            right=mid-1
        }else
            left=mid+1
    }

    println(answer2136)
}
fun possible(num:Int):Boolean{
    var tmp1=1
    var tmp2=num
    for(i in 0 until input2136[0])
    {
        if(num< arraylist2136[i])
            return false
        if(tmp2- arraylist2136[i] <0)
        {
            tmp2=num
            tmp1++
        }
        tmp2-= arraylist2136[i]
    }
    return input2136[1]>=tmp1
}