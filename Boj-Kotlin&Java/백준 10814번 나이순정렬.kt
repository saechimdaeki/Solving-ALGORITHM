package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    var arr=ArrayList<Pair<Int,String>>()
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ")
        arr.add(Pair(input[0].toInt(),input[1]))
    }
    val ppp =arr.sortedWith(compareBy {it.first})
    //arr.sortBy { it.first }

    for(i in ppp)
        println("${i.first} ${i.second}")
}