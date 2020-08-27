package 백준

fun main() {
    val n=System.`in`.bufferedReader().readLine().toInt()
    var answer:Long=0
    for(i in 1..n)
        answer+=jari(i)
    println(answer)
}
private fun jari(x:Int):Int{
    var n=x
    var answer=0
    while (n!=0){
        n/=10
        answer++
    }
    return answer
}