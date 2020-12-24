package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it.toInt() }
    var answer=0
    arr.indices.forEach { i ->
        answer = answer xor arr[i]
    }
    when (answer) {
        0 -> println("cubelover")
        else -> println("koosaga")
    }
}