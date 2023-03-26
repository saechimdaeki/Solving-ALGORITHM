package boj1253

var n = 0
var answer = 0
lateinit var arr: IntArray
fun main() {
    n = readLine()!!.toInt()
    arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    arr.sort()
    answer = (0 until n).count { possible(it) }
    println(answer)
}

fun possible(idx: Int): Boolean {
    var left = 0
    var right = n - 1
    val target = arr[idx]
    while (left < right) {
        if (left == idx)
            left++
        else if (right == idx)
            right--
        else {
            if (arr[left] + arr[right] == target)
                return true
            if (arr[left] + arr[right] > target)
                right--
            else
                left++
        }
    }
    return false
}