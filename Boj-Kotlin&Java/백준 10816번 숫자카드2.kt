package boj14681kot

private lateinit var arr: IntArray
private var n=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    n=br.readLine().toInt()
    arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val m =br.readLine().toInt()
    val arr2=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    arr.sort()
    for(i in arr2)
    {
        var l= lower_bound(i)
        var r= upper_bound(i)
        if(l==-1)
            print("0 ")
        else
        print("${r-l+1} ")
    }
}
private fun lower_bound(x:Int):Int{
    var left=0
    var right=n-1
    var answer=-1
    while(left<=right)
    {
        var mid=(left+right)/2
        if(arr[mid]==x)
        {
            answer=mid
            right=mid-1
        }else if(arr[mid]>x)
            right=mid-1
        else
            left=mid+1
    }
    return answer
}
private fun upper_bound(x:Int):Int{
    var left=0
    var right=n-1
    var answer=-1
    while(left<=right)
    {
        var mid=(left+right)/2
        if(arr[mid]==x)
        {
            answer=mid
            left=mid+1
        }
        else if(arr[mid]>x)
            right=mid-1
        else
            left=mid+1
    }
    return answer
}