package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val arr=br.readLine().split(" ").map { it.toLong() }
    val list=LongArray(n+1)
    list[0]=0
    for(i in 1 until n){
        list[i]=arr[i-1]+list[i-1]
    }
    val answer= arrayListOf<Long>()
    for(i in m until n){
        answer.add(list[i]-list[i-m])
    }
    println(answer.max())
}