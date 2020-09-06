package 구름

import java.util.Scanner
fun main(args: Array<String>) {
    val (a,b) = readLine()!!.split(" ").map { it.toInt() }
    println(a shr b)
    println(a shl b)
}