
private val checked=Array(50*20+1){false}
private var answer=0
fun main()
{
    val n=System.`in`.bufferedReader()
            .readLine().toInt()
    for(i in 0..n)
    {
        for(j in 0..n-i)
        {
            for(k in 0 ..n-i-j)
            {
                var l=n-i-j-k
                checked[i+5*j+10*k+50*l]=true
            }
        }
    }
    for(i in 0 ..50*20)
    {
        if(checked[i])
            answer++
    }
    println(answer)
}
