package 구름

import kotlin.math.sqrt
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val input = readLine()!!.toInt()
    for(i in input-1 downTo 2)
        if(input%i==0){
            println("False")
            exitProcess(0)
        }
    println("True")
}