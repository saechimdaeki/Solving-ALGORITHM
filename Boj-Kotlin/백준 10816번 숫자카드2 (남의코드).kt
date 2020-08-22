package boj14681kot

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).apply {
        readLine()
        readLine().split(" ").groupBy { it }.apply {
            readLine()
            readLine().split(" ").joinToString(" ") { (this[it]?.count() ?: 0).toString() }.also { println(it) }
        }
    }
}