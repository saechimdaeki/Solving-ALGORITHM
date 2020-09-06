package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    var answer=0
    val search=br.readLine()
    val n=br.readLine().toInt()
    repeat(n){
        var input=br.readLine()
        input+=input
        if(input.contains(search))
            answer++
    }
    println(answer)

}