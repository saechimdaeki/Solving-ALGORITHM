package boj2003

fun main() {
    val (n,m) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    var start = 0
    var end = 0
    var sum =0
    var answer =0
    while (true) {
        if(sum >= m) {
            if (sum ==m) answer++
            sum-=arr[start++]
        }
        else if(end == n) break
        else sum+=arr[end++]
    }
    println(answer)
}