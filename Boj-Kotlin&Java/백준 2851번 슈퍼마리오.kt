import kotlin.math.abs

fun main() {
    val br=System.`in`.bufferedReader()
    var sum=0
    val list= arrayListOf<Int>()
    val answerlist= arrayListOf<Int>()
    for(i in 0 until 10)
    {
        val input=br.readLine().toInt()
        sum+=input
        list.add(sum)
    }
    for(i in 0 until list.size)
    {
       answerlist.add(abs(100-list[i]))
    }
    if(list.contains(100+answerlist.min()!!))
        println(100+answerlist.min()!!)
    else{
        println(100-answerlist.min()!!)
    }
}