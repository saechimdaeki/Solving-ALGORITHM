package boj14681kot

fun main()
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it->it.toInt() }.toIntArray()
    arr.sort()
    val list2=ArrayList<Int>()
    var tmp=0
    for(i in arr)
    {
        tmp+=i
        list2.add(tmp)
    }
    println(list2.sum())
}