package boj14681kot

import kotlin.math.pow

private val bw=System.out.bufferedWriter()
private var cnt=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val k=br.readLine().toInt()
    bw.write((2.0.pow(k).toInt()-1).toString())
    bw.write("\n")
    solve(k,1,3)
    bw.flush()
}
private fun solve(n:Int,x:Int,y:Int)
{
    if(n==0)
        return
    solve(n-1,x,6-x-y)
    cnt++
    bw.write("$x $y\n")
    solve(n-1,6-x-y,y)
}