package boj6159

fun main() {
    val (n,s) = readLine()!!.split(" ").map { it.toInt() }
    val arr = IntArray(n)
    repeat(n) {
        arr[it] = readLine()!!.toInt()
    }
    arr.sort()
    var answer =0
    var start =0
    var end = 1

    while (start< end) {
        end = start+1
        if(arr[start] >= s) break
        while (end< n) {
            val sum = arr[start] + arr[end]
            if(sum <= s) {
                answer++
                end++
            }else {
                break
            }
        }
        start++
    }
    println(answer)
}