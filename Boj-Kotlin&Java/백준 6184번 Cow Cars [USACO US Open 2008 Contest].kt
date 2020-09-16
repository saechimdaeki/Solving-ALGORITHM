package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m,d,l)=br.readLine().split(" ").map { it.toInt() }
    val list= arrayListOf<Int>()
    var answer=0
    repeat(n){
        list.add(br.readLine().toInt())
    }
    list.sort()
    for(i in list){
        val tmp=answer/m
        if(i-tmp*d>=l) answer++
    }
    println(answer)
}