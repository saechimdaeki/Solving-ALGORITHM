import kotlin.math.max

private var n=0
private var sooSik=""
private var answer=Int.MIN_VALUE
fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
     n=br.readLine().toInt()
    sooSik=br.readLine()
    bruteForce(0,0)
    println(answer)
}
private fun bruteForce(idx:Int,now:Int){
    var tmp=' '
    if(idx>n-1)
    {
        answer= max(answer,now)
        return
    }
    tmp = if(idx==0)
        '+'
    else
        sooSik[idx-1]
    if(idx+2<n)
    {
        var temp=calculate(sooSik[idx]-'0',sooSik[idx+2]-'0',sooSik[idx+1])
        bruteForce(idx+4,calculate(now,temp,tmp))
    }
    bruteForce(idx+2,calculate(now,sooSik[idx]-'0',tmp))
}
private fun calculate(a:Int,b:Int,symbol:Char):Int{
    var ans=0
    when(symbol)
    {
        '+' -> ans=a+b
        '-' ->ans=a-b
        '*' ->ans=a*b
    }
    return ans
}
