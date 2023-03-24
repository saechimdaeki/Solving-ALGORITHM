package boj1182

var answer = 0
fun main() {
    val (n, s) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    dfs(arr,s,0,0, n)

    println(
        when (s) {
            0 -> answer-1
            else -> answer
        }
    )
}

fun dfs(arr:IntArray, targetSum: Int, idx:Int, nowSum:Int, n :Int ) {
    when (idx) {
        n -> {
            if(targetSum == nowSum)
                answer++
            return
        }
        else -> {
            dfs(arr, targetSum, idx + 1, nowSum, n)
            dfs(arr, targetSum, idx + 1, nowSum + arr[idx], n)
        }
    }
}