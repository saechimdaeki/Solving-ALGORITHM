package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    var string=br.readLine()
    val target=br.readLine()
    var answer=0
    while(true) {
        val i = string.indexOf(target)
        if(i==-1)
            break
        else
            answer++
        string = string.substring(i + target.length, string.length)
    }
        println(answer)


}