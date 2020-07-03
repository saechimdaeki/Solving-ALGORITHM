package boj14681kot

private lateinit var arr:IntArray
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n =br.readLine().toInt()
    arr=br.readLine().split(" ").map { it->it.toInt() }.toIntArray()
    val list=ArrayList<Int>()
    for(i in arr.size-1 downTo 0)
    {
       list.add(arr[i],i)
    }
    for(i in list)
        print("${i+1} ")
}