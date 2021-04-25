package 해커랭크

import java.util.*

fun birthdayCakeCandles(ar: Array<Int>): Int {
    var answer=0
    var cnt=0
    for(i in ar.indices){
        if(ar[i]>answer) {
            answer = ar[i]
        }
    }

    for(i in ar.indices){
        if(answer==ar[i])
            cnt++
    }
    return cnt
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arCount = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = birthdayCakeCandles(ar)

    println(result)
}
