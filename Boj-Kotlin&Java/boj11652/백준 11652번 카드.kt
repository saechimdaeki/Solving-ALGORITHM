package boj11652

fun main() {
    val n = readLine()!!.toInt()
    val arr = LongArray(n)
    repeat(n) {
        arr[it] = readLine()!!.toLong()
    }
    arr.sort()

    // 지금 숫자 등장횟수
    var currentCnt = 1
    // 최빈값 등장횟수
    var maxCnt = 1
    // 최빈값
    var num = arr[0]

    for(i in 1 until n) {
        if (arr[i] == arr[i-1]) {
            currentCnt++
        } else {
            currentCnt = 1
        }
        if(maxCnt < currentCnt) {
            maxCnt = currentCnt
            num = arr[i]
        }
    }
    println(num)
}