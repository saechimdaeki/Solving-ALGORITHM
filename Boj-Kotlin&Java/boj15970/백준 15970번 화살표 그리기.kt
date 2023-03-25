package boj15970

import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val list = Array<ArrayList<Int>>(n+1){ ArrayList() }
    repeat(n) {
        val (position, color) = readLine()!!.split(" ").map { it.toInt() }
        list[color].add(position)
    }

    list.forEach { ints ->
        ints.sort()
    }
    var answer = 0

    for ( i in 0 .. n) {
        for(j in 0 until list[i].size) {
            val left = if(j == 0) Int.MAX_VALUE else list[i][j] - list[i][j-1]
            val right = if(j == list[i].size-1) Int.MAX_VALUE else list[i][j+1] - list[i][j]
            answer += min(left, right)
        }
    }
    println(answer)
}