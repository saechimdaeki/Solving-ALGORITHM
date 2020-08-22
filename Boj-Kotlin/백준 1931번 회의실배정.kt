package boj14681kot
private var answer=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=ArrayList<Pair<Int,Int>>()
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it->it.toInt()}
        arr.add(Pair(input[0],input[1]))
    }
   val comparator= compareBy<Pair<Int,Int>>{it.second}
    val comparator2= comparator.thenBy { it.first }
   val result= arr.sortedWith(comparator2)
    var now=0
    for(i in result)
    {
        if(now<=i.first)
        {
            now=i.second
            answer++
        }
    }
    println(answer)
}