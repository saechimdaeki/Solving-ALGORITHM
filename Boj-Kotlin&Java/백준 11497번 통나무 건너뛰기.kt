package 백준

import kotlin.math.max

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    repeat(t){
        val trash=br.readLine().toInt()
        val arr=br.readLine().split(" ").map { it.toInt() }.sorted()
        var maxi=0
        (2 until trash)
                .forEach { i ->
                    maxi= max(maxi,arr[i]-arr[i-2])
                }
        bw.write("$maxi\n")
    }
    bw.flush()
}