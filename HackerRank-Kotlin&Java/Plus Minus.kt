package 해커랭크

import java.util.*

fun plusMinus(arr: Array<Int>): Unit {
    val n=arr.size
    var (minus,plus,zero)= intArrayOf(0,0,0)
    for(i in arr.indices){
        when {
            arr[i]<0 -> minus++
            arr[i]==0 -> zero++
            else -> {
                plus++
            }
        }
    }
    println("${plus.toFloat()/n.toFloat()}")
    println("${minus.toFloat()/n.toFloat()}")
    println("${zero.toFloat()/n.toFloat()}")

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    plusMinus(arr)
}