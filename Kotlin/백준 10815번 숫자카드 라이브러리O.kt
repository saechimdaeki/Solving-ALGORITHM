package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n =br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val m=br.readLine().toInt()
    val arr2=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    arr.sort()
    for(i in arr2)
    {
        if(arr.binarySearch(i)>=0)
            print("1 ")
        else
            print("0 ")
    }
}