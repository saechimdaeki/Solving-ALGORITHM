package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val words=Array(n){br.readLine()}
    val alpha=Array(26){0}
    for(i in words)
    {
        var mul=1
        for(j in i.length-1 downTo 0)
        {
            alpha[i[j]-'A']+=mul
            mul*=10
        }
    }
    alpha.sortDescending()
    var answer=0
    for(i in 0 until 10)
        answer+=alpha[i]*(9-i)
    println(answer)
}