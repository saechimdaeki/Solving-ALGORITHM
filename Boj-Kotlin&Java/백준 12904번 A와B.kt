package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    var s=br.readLine()
    var t=br.readLine()
    while(true)
    {
        if(s.length==t.length)
            break

        if(t[t.length-1]=='A')
            t=t.substring(0,t.length-1)
        else{
            t=t.substring(0,t.length-1)
            t=t.reversed()
        }
    }
    if(s==t)
        println(1)
    else
        println(0)
}