package boj9663

import kotlin.math.abs

lateinit var arr : IntArray

var answer = 0
var n = 0
fun main() {
    n = readLine()!!.toInt()
    arr = IntArray(n+1)
    dfs(0)
    println(answer)
}

fun dfs(idx: Int) {
    if(idx == n) {
        answer++
        return
    }
    for(i in 0 until  n){
        arr[idx] = i
        if(check(idx))
            dfs(idx+1)
    }
}

fun check(col: Int) : Boolean {
    for(i in 0 until col) {
        if(arr[i] == arr[col] || abs(arr[i]- arr[col]) == abs(i-col))
            return false
    }
    return true
}

