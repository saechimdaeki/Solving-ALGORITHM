package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val list= arrayListOf<Int>()
    repeat(n){
        list.add(br.readLine().toInt())
    }
    list.sortDescending()
    var sum=0
    loop@ for(i in list.indices){
        when {
            (i+1)%3==0 -> continue@loop
        }
        sum+=list[i]
    }
    println(sum)
}