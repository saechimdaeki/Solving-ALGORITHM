package boj2470

import kotlin.math.abs

fun main() {
    val n = readln()!!.toInt()
    val arr = readln()!!.split(" ").map { it.toInt() }.sorted().toIntArray()
    var answer1 =0
    var answer2 =0
    var tmp = Int.MAX_VALUE

    (0 until n).forEach { i ->
        var left = i+1
        var right = n-1
        while (left<=right) {
            val mid = (left+right)/2
            val sum = arr[i] + arr[mid]
            when {
                abs(sum) < tmp -> {
                    tmp = abs(sum)
                    answer1 = arr[i]
                    answer2 = arr[mid]
                }
            }
            when {
                sum <0 -> {
                    left = mid+1
                }
                else -> right = mid-1
            }

        }
    }
    println("$answer1 $answer2")

}