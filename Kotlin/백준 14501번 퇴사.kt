package boj14681kot

private var answer=0
private var n=0
private lateinit var arr:Array<Pair<Int,Int>>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    n= br.readLine().toInt()
    arr=Array(n){Pair(0,0)}
    for(i in 0 until n)
    {
        val (a, b)=br.readLine().split(" ").map { it->it.toInt() }
        arr[i]=arr[i].copy(first=a,second = b)
    }
    solve(0,0)
    println(answer)
}
private fun solve(day:Int,sum:Int){
    if(day==n)
    {
        if(answer<sum)
            answer=sum
        return
    }
    if(day>n)
        return
    solve(day+arr[day].component1(),sum+arr[day].component2())
    solve(day+1,sum)
}