package 백준

fun main() {
    val (n,k)= readLine()!!.split(" ").map { it.toInt() }
    var answer=0
    for(i in 1..n){
        val tmp=i.toString()
        for(j in tmp.indices){
            if(tmp[j]==k.toString()[0])
                answer++
        }
    }
    println(answer)
}