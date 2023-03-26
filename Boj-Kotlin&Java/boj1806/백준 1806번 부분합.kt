package boj1806

var answer = Int.MAX_VALUE
fun main() {
    val (n, s) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    var end = 0
    var sum = 0
    var start =0

    while (true) {
        if(sum >=s) {
            sum-=arr[start++]
            answer = minOf(answer, end-start+1)
        }
        else if(end==n) break
        else sum+=arr[end++]
    }
    println(if(answer == Int.MAX_VALUE) 0 else answer)
}