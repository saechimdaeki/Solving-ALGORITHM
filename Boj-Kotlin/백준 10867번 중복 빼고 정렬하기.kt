package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    var n=br.readLine().toInt()
    var input=br.readLine().split(" ").map { it->it.toInt() }
            .toSet()
            .sorted()
    for(i in input)
        print("$i ")
}