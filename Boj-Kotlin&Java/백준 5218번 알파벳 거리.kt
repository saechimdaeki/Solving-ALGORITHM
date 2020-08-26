package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    for(i in 0 until n )
    {
        val input=br.readLine().split(" ")
        bw.write("Distances: ")
        for(j in input[0].indices)
        {
            if (input[1][j]-input[0][j]<0)
                bw.write("${input[1][j]-input[0][j]+26} ")
            else
                bw.write("${input[1][j]-input[0][j]} ")
        }
        bw.write("\n")
    }
    bw.flush()
}