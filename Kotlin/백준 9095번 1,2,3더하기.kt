package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var array=Array(12,{0})
    val t=br.readLine().toInt()
    array[0]=1
    array[1]=1
    array[2]=2
    array[3]=4
    for(i in 4 until 12)
    {
        array[i]=array[i-1]+array[i-2]+array[i-3]
    }
    for(i in 0 until t step 1)
    {
        val tmp=br.readLine().toInt()
        bw.write("${array[tmp]}\n")
    }
    bw.flush()
}