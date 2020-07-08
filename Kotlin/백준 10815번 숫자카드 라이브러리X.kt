package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val m=br.readLine().toInt()
    arr.sort()
    val arr2=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    // 라이브러리가아닌 직접 구현으로 해보장
    for(i in arr2)
    {
        var left=0
        var right=n-1
        var check=false
        gg@while(left<=right)
        {
            var mid=(left+right)/2
            if(arr[mid]==i)
            {
                check=true
                break@gg
            }
            else if(arr[mid]>i)
                right=mid-1
            else
                left=mid+1
        }
        if (check)
            print("1 ")
        else
            print("0 ")
    }


}