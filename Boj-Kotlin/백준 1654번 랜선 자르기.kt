private var answer=0L
private lateinit var list:ArrayList<Long>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (k,n)=br.readLine().split(" ").map { it.toLong() }
    list=ArrayList()
    for(i in 0 until k)
        list.add(br.readLine().toLong())
    var left=1L
    var right=list.max()!!
    while(left<=right)
    {
        var mid=(left+right)/2
       // println("왼쪽: $left,미드값 $mid 오른쪽:$right")
        if(solve(mid,n))
        {
            if(answer<mid)
            answer=mid
            left=mid+1
        }else
            right=mid-1
    }
    println(answer)
}
private fun solve(n1:Long,n2:Long):Boolean
{
    var tmp=0L
    for(i in 0 until list.size)
    {
        tmp+=(list[i]/n1)
    }
    return tmp>=n2
}