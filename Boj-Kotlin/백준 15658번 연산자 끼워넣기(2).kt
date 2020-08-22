package boj14681kot

import kotlin.math.max
import kotlin.math.min

private lateinit var arr:IntArray
private lateinit var susik:IntArray
private var n =0
private var maxi=Int.MIN_VALUE
private var mini=Int.MAX_VALUE
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    n=br.readLine().toInt()
    arr=br.readLine().split(" ").map { it->it.toInt() }.toIntArray()
    susik=br.readLine().split(" ").map { it->it.toInt() }.toIntArray()
    kot(1,arr[0])
    println(maxi)
    println(mini)
}
private fun kot(idx:Int,sum:Int){
    if(idx>=n)
    {
        maxi= max(maxi,sum)
        mini= min(mini,sum)
        return
    }
    for(i in 0 until 4)
    {
        if(susik[i]==0)
            continue
        susik[i]--
        when(i){
            0 -> kot(idx+1,sum+arr[idx])
            1 -> kot(idx+1,sum-arr[idx])
            2-> kot(idx+1,sum*arr[idx])
            3-> kot(idx+1, sum/arr[idx])
        }
        susik[i]++
    }
}