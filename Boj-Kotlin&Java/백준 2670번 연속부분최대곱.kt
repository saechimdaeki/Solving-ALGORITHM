package 백준

import kotlin.math.max
import kotlin.math.roundToInt
import kotlin.system.exitProcess

fun main() {
    val n= readLine()!!.toInt()
    val arr= arrayListOf<Double>()
    repeat(n){
        arr.add(readLine()!!.toDouble())
    }
    var maxi=Double.MIN_VALUE
    for(i in 0 until n){
        var sum=1.0
        for(j in i until n){
            sum *=arr[j]
            maxi= max(sum,maxi)
        }
    }
    val tmp=((maxi*1000).roundToInt() /1000f).toString()+"000"
    var check=false
    var cnt=0
    for(i in tmp.indices){
        if(tmp[i]=='.')
            check=true
        if (cnt==4) exitProcess(0)
        if(check){
            print("${tmp[i]}")
            cnt++
        }else print("${tmp[i]}")
    }
}