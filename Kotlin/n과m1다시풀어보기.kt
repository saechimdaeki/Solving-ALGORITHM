package boj14681kot

private var arr=Array(10){0}
private var n=0
private var m=0
private var checked=Array<Boolean>(10){false}
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val input=br.readLine().split(" ")
    n=input[0].toInt()
    m=input[1].toInt()
    for(i in 0 until n)
        arr[i]=i+1
    recursive1(0)
}
private fun recursive1(index:Int){
    if(index==m)
    {
        for(i in 0 until m)
            print("${arr[i]} ")
        println()
        return
    }
    for(i in 1 .. n)
    {
        if(checked[i])
            continue
        checked[i]=true
        arr[index]=i
        recursive1(index+1)
        checked[i]=false
    }

}