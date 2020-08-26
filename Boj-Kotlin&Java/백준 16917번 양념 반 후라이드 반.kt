import kotlin.math.max

fun main()
{
    val (a,b,c,x,y)=System.`in`.bufferedReader()
            .readLine().split(" ").map { it.toInt() }
    var answer=x*a+y*b
    for(i in 1..100000)
    {
        var price=2*i*c+ max(0,x-i)*a+ max(0,y-i)*b
        if(answer>price)
            answer=price
    }
    println(answer)
}