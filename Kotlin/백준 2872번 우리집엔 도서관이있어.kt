package boj14681kot
private var answer=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    var num=n
    val list=ArrayList<Any>()
    for(i in 0 until n)
        list.add(br.readLine().toInt())
    for(i in n-1 downTo 0)
    {
        if(list[i]==num)
            num--
        else
            answer++
    }
    println(answer)
}