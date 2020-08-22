package boj14681kot

private val bw=System.out.bufferedWriter()
private lateinit var arr:ArrayList<Int>
private lateinit var arr2:Array<Int>
private var checked=Array<Boolean>(10){false}
private var n=0
private var m=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val input=br.readLine().split(" ")
    n=input[0].toInt()
    m=input[1].toInt()
    arr= ArrayList()
    arr2= Array(n){0}
    val arrayinput=br.readLine().split(" ")
    for(i in 0 until n)
        arr.add(arrayinput[i].toInt())
    arr.sort()
    recursive1(0)
    bw.flush()
}
private fun recursive1(index:Int)
{
    if(index==m)
    {
        for(i in 0 until m)
            bw.write("${arr[arr2[i]]} ")
        bw.write("\n")
        return
    }
    for(i in 0 until n)
    {
        if(checked[i])
            continue
        checked[i]=true
        arr2[index]=i
        recursive1(index+1)
        checked[i]=false
    }
}