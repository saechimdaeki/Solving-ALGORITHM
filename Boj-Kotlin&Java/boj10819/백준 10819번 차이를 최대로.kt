package boj10819

import kotlin.math.abs


var n = 0
lateinit var arr: IntArray
lateinit var visited: BooleanArray
lateinit var result: IntArray
var max = 0
fun main() {
    n = readLine()!!.toInt()
    arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    visited = BooleanArray(n)
    result  = IntArray(n)

    dfs(0)
    println(max)
}

fun dfs(depth: Int) {
    if(depth == n) {
        val sum = (0 until n-1).sumOf { abs(result[it] - result[it +1]) }
        max = maxOf(max, sum)
        return
    }
    for(i in 0 until n) {
        if(!visited[i]) {
            visited[i] = true
            result[depth] = arr[i]
            dfs(depth+1)
            visited[i] = false
        }
    }
}