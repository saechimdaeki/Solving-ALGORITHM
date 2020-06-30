package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var array=Array(43,{0})
    val t=br.readLine().toInt()
    array[0]=1
    array[1]=0
    array[2]=1
    for (i in 3 until 42 step 1)
    {
        array[i]=array[i-2]+array[i-1]
    }
    for(i in 0 until t)
    {
        var tmp=br.readLine().toInt()
        println("${array[tmp]} ${array[tmp+1]}")
    }
}