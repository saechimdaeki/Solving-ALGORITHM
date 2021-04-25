package 해커랭크

import java.util.*

fun miniMaxSum(arr: Array<Int>): Unit {
    var sum:Long=0
    for(i in arr.indices)
        sum+=arr[i]
    val list= arrayListOf<Long>()
    for(i in arr.indices)
        list.add((sum-arr[i]))
    print("${list.min()} ${list.max()}")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    miniMaxSum(arr)
}