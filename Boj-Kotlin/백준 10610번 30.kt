package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine()
    var tmp=0
    for(i in n)
        tmp+=i-'0'
    val sortn= n.toCharArray().apply { sort() }
    if(tmp%3==0 && sortn[0]=='0')
    {
        for(i in sortn.size-1 downTo 0)
            print("${sortn[i]}")
    }else
        println(-1)
}