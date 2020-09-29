package 백준

import kotlin.math.pow
import kotlin.system.exitProcess

fun main() {
    val br=System.`in`.bufferedReader()
    val (a,p)=br.readLine().split(" ").map { it.toInt() }
    val arr= arrayListOf<Int>()
    arr.add(a)
    while (true){
        var tmp=arr[arr.size-1]
        var value=0
        while (tmp!=0){
            value+= (tmp % 10).toDouble().pow(p.toDouble()).toInt()
            tmp/=10
        }
        if(arr.contains(value)){
            println(arr.indexOf(value))
            exitProcess(0)
        }
        arr.add(value)
    }
}
