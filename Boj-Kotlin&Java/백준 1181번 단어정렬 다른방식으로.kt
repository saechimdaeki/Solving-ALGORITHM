package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    var list= mutableSetOf<String>()
    for(i in 0 until n)
        list.add(br.readLine())
    val lengthcomparator= compareBy<String>{it.length}
    val aftercomp=lengthcomparator.thenBy { it }
    list=list.sortedWith(aftercomp).toMutableSet()
    for(i in list)
        println(i)
}