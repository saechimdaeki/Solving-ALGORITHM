package boj14681kot

import kotlin.math.pow


private var tmp=1
private var answer=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n,r,c)=br.readLine().split(" ").map { it.toInt() }
    for(i in 0 until n)
        tmp*=2

    solve(tmp,0,0,r,c)
}
private fun solve(z:Int,x:Int,y:Int,r:Int,c:Int)
{
   if(z==1)
   {
       if(x==r && y==c)
           println(answer)
       answer++
       return
   }
    var s=z/2
    solve(s,x,y,r,c)
    solve(s,x,y+s,r,c)
    solve(s,x+s,y,r,c)
    solve(s,x+s,y+s,r,c)
}

