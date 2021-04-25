package 해커랭크

import kotlin.math.abs

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    // Write your code here
    var (suma,sumb)= intArrayOf(0,0)
    var cnt=0
    for(i in arr.indices){
        for(j in arr[i].indices){
            if(i==j) {
                suma += arr[i][j]
            }
            if(i==cnt && j==arr.size-1-cnt)
            {
                sumb+=arr[i][j]
                cnt++
            }
        }
    }
    return abs(suma-sumb)
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

    for (i in 0 until n) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = diagonalDifference(arr)

    println(result)
}
