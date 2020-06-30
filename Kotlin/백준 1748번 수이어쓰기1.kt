package boj14681kot

private var count:Long=0
private var n=0

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    n=br.readLine().toInt()
    for(i in 1..n)
        count+= jar(i)
    print(count)
}
fun jar(n1: Int):Int{
    var tmp=n1
    var answer=0
    while(tmp!=0)
    {
        tmp/=10
        answer++
    }
    return answer
}