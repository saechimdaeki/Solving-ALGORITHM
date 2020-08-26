private var answer=0L
private lateinit var arr:ArrayList<Long>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n,c)=br.readLine().split(" ").map { it.toInt() }
    arr= ArrayList()
    for(i in 0 until n)
        arr.add(br.readLine().toLong())
    var left=1L
    var right=arr.max()!!-arr.min()!!
    arr.sort()
    while(left<=right)
    {
        var mid=(left+right)/2
        if (possible(mid,n,c))
        {
            answer=mid
            left=mid+1
        }else
            right=mid-1
    }
    println(answer)
}
private fun possible(mid:Long,n1:Int,c1:Int):Boolean{
    var cnt=1
    var last=arr[0]
    for(i in arr)
    {
        if(i-last>=mid)
        {
            cnt++
            last=i
        }
    }
    return cnt>=c1
}