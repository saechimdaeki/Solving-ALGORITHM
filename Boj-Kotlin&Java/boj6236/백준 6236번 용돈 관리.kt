package boj6236

lateinit var arr: IntArray
var answer = 0
fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    arr = IntArray(n)
    repeat(n) {
        arr[it] = readLine()!!.toInt()
    }
    val totalPrice = arr.sum()

    var left = arr.maxOf { it }
    var right = totalPrice
    while (left <= right) {
        val mid = (left + right) / 2
        if (isPossible(mid, m) ) {
            answer = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    println(answer)
}

fun isPossible(mid: Int, m: Int): Boolean {
    var cnt = 1
    var sum = 0
    for(i in arr.indices) {
        sum+= arr[i]
        if(sum > mid){
            cnt++
            sum = arr[i]
        }
    }
    return cnt<=m
}