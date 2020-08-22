package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    var s=br.readLine()
    var t=br.readLine()
    val answer= oneorzero(s,t)
    if(answer)
        println(1)
    else
        println(0)
}
private fun oneorzero(s1:String, s2:String):Boolean{
    if(s1==s2)
        return true
    if(s2.isNotEmpty())
    {
        if(s2[s2.length-1]=='A' && oneorzero(s1,s2.substring(0,s2.length-1)))
            return true
        if(s2[0]=='B' && oneorzero(s1, s2.reversed().substring(0,s2.length-1)))
            return true
    }
    return false
}