package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,q)=br.readLine().split(" ").map { it.toInt() }
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    arr.sort()
    repeat(q){
        val (a,b)=br.readLine().split(" ").map { it.toInt() }
        bw.write("${upperBound(arr,b)- lower_bound(arr,a)}\n")
    }
    bw.flush()
}
private fun lower_bound(a: IntArray, `val`: Int): Int {
    var left = 0
    var right = a.size
    while (left < right) {
        val mid = (left + right) / 2
        if (a[mid] >= `val`) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}
private fun upperBound(a: IntArray, `val`: Int): Int {
    var left = 0
    var right = a.size
    while (left < right) {
        val mid = (left + right) / 2
        if (a[mid] <= `val`) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}