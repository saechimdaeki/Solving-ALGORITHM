package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=Array(n){Pair(0,0)}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it->it.toInt() }
        arr[i]=arr[i].copy(first=input[0],second = input[1])
    }
    arr.sortBy { it.first }
    arr.sortBy { it.second }

    for(i in 0 until n)
    {
        println("${arr[i].first} ${arr[i].second}")
   }
}