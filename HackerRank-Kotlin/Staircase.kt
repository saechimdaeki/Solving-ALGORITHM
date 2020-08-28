package 해커랭크

import java.util.*

fun staircase(n: Int): Unit {
    for(i in 1..n){
        val tmp=n-i
        for(j in 1..tmp)
            print(" ")
        for(j in 1..i)
            print("#")
        if(i<n)
            println()
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    staircase(n)
}