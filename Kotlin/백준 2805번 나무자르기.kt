import kotlin.math.max

private var answer=0L
private lateinit var namoo:LongArray
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toLong() }
    namoo=br.readLine().split(" ").map { it.toLong() }.toLongArray()
    var left=1L
    var right=namoo.max()!!
    while(left<=right)
    {
        var mid=(left+right)/2
        if(possible(mid,n,m))
        {
            answer= max(answer,mid)
            left=mid+1
        }else
            right=mid-1
    }
    println(answer)
}
private fun possible(mid:Long,n1:Long,m1:Long):Boolean{
    var sum=0L
    for(i in 0 until n1.toInt())
    {
        if(namoo[i]-mid>0)
            sum+=(namoo[i]-mid)
    }
    return sum>=m1
}