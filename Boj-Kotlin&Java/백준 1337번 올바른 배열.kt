package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr= arrayListOf<Int>()
    repeat(n){
        arr.add(br.readLine().toInt())
    }
    arr.sort()
    var cnt=1
    var index=0
    var max=1
    for(i in 1 until n){
        cnt++
        while (arr[i]-arr[index]>4){
            index++
            cnt--
        }
        max= kotlin.math.max(max,cnt)
    }
    when {
        max <= 5 -> {
            println(5-max)
        }
        else -> {
            println(5)
        }
    }
}