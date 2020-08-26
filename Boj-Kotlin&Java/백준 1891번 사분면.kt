package boj14681kot

import java.util.*

internal class Pair(var row: Long, var col: Long)


var two = LongArray(51)
private fun go(a: String, index: Int, r: Long, c: Long, size: Long): Pair {
    if (size == 1L) {
        return Pair(r, c)
    } else {
        if (a[index] == '1') {
            return go(a, index + 1, r, c + size / 2, size / 2)
        } else if (a[index] == '2') {
            return go(a, index + 1, r, c, size / 2)
        } else if (a[index] == '3') {
            return go(a, index + 1, r + size / 2, c, size / 2)
        } else if (a[index] == '4') {
            return go(a, index + 1, r + size / 2, c + size / 2, size / 2)
        }
    }
    return Pair(0, 0)
}

private fun gogo(r: Long, c: Long, size: Long, x: Long, y: Long): String {
    if (size == 1L) {
        return ""
    }
    return if (x < r + size / 2 && y < c + size / 2) {
        "2" + gogo(r, c, size / 2, x, y)
    } else if (x < r + size / 2 && y >= c + size / 2) {
        "1" + gogo(r, c + size / 2, size / 2, x, y)
    } else if (x >= r + size / 2 && y < c + size / 2) {
        "3" + gogo(r + size / 2, c, size / 2, x, y)
    } else {
        "4" + gogo(r + size / 2, c + size / 2, size / 2, x, y)
    }
}


fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    two[0] = 1
    for (i in 1..50) {
        two[i] = two[i - 1] * 2L
    }
    val n = sc.nextInt()
    val a = sc.next()
    val size = two[n]
    val p = go(a, 0, 0, 0, size)
    val dc = sc.nextLong()
    var dr = sc.nextLong()
    dr = -dr
    p.row += dr
    p.col += dc
    if (p.row in 0 until size && 0 <= p.col && p.col < size) {
        println(gogo(0, 0, size, p.row, p.col))
    } else {
        println(-1)
    }
}