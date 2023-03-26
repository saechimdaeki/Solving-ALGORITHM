package boj26091

fun main() {
    val (n,m) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    arr.sort()
    var answer = 0

    var start = 0
    var end = n-1

    while (start< end) {
        val sum = arr[start] + arr[end]
        if( sum  >= m ){
            answer ++
            start ++
            end --
        }else {
            start ++
        }
    }
    println(answer)
}