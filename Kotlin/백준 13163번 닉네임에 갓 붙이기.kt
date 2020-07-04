package boj14681kot

fun main(args:Array<String>)
{
    val br= System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ")
        var s="god"
        for(i in 1..input.size-1)
            s+=input[i]
        bw.write(s+"\n")
    }
    bw.flush()
}