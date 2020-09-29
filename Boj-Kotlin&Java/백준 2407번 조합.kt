package 백준

import java.math.BigInteger

fun main() {
    val (n,m)= readLine()!!.split(" ").map { it.toInt() }
    var one=BigInteger.ONE
    var two=BigInteger.ONE
    for(i in 0 until m){
        one=one.multiply((n-i).toBigInteger())
        two=two.multiply((i+1).toBigInteger())
    }
    println(one.divide(two))
}