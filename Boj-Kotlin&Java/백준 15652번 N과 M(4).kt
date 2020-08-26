package boj14681kot

private var n=0
private var m=0
private var arr=Array<Int>(10){0}
private val bw=System.out.bufferedWriter()
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val input=br.readLine().split(" ")
    n=input[0].toInt()
    m=input[1].toInt()
    recursive1(0,1)
    bw.flush()
}
private fun recursive1(index:Int, start:Int)
{
    if(index==m)
    {
        for(i in 0 until m)
        bw.write("${arr[i]} ")
        bw.write("\n")
        return
    }
    for(i in start..n)
    {
        arr[index]=i
        recursive1(index+1,i)
    }
}