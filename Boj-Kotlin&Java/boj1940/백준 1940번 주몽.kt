package boj1940

fun main() {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val arr= readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    arr.sort()
    var answer = 0

    var start = 0

    var end = n-1


    while(start < end) {
       val sum = arr[start] + arr[end]
        if(sum ==m) {
            answer++
            start++
        }else {
            if(sum < m) {
                start++
            }else {
                end--
            }
        }
    }
    println(answer)
}