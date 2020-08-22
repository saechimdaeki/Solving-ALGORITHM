package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val input=br.readLine().split(" ")
    var n=input[0].toInt()
    var k=input[1].toInt()
    var arr=ArrayList<Int>()
    var answer=0
    for(i in 0 until n)
        arr.add(br.readLine().toInt())
    arr.sortDescending()
    for(i in 0 until n)
    {
        answer+=k/arr[i]
        k%=arr[i]
    }
    println(answer)
}