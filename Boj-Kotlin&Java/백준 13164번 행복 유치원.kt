package 백준

import java.util.*

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,k)=br.readLine().split(" ").map { it.toInt() }
    val st=StringTokenizer(br.readLine())
    val arr=IntArray(n)
    (0 until n)
            .forEach { i ->
                arr[i]=st.nextToken().toInt()
            }
    (1 until n).forEach { i ->
        arr[i-1]=arr[i]-arr[i-1]
    }.also {
        arr.sort()
      println((0 until n-k).sumBy { arr[it] })
    }
    // TC 오류있는문제라 STRINGTOKENIZER사용
}