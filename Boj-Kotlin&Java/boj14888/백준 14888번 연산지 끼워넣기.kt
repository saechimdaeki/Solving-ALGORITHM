package boj14888

var min = Int.MAX_VALUE
var max = Int.MIN_VALUE

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val oper = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    dfs(arr, oper, arr[0], 1)
    println(max)
    println(min)
}

fun dfs(arr:IntArray, oper:IntArray, nowValue :Int, idx: Int) {
    if(idx == arr.size) {
        min = minOf(min, nowValue)
        max = maxOf(max, nowValue)
        return
    }

    (0 until 4).forEach { i ->
        when {
            oper[i] > 0 -> {
                oper[i]--
                when (i) {
                    0 -> dfs(arr,oper, nowValue + arr[idx], idx+1)
                    1 -> dfs(arr,oper, nowValue - arr[idx], idx+1)
                    2 -> dfs(arr,oper, nowValue * arr[idx], idx+1)
                    else -> dfs(arr, oper, nowValue/arr[idx], idx+1)
                }
                oper[i]++
            }
        }
    }
}

