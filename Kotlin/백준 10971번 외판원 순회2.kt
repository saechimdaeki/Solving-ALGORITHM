package boj14681kot

private lateinit var arr:Array<Array<Int>>
private var n=0
private var list=ArrayList<Int>()
private lateinit var a:Array<Int>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    n=br.readLine().toInt()
    arr=Array(n){Array(n){0}}
     a=Array(n){0}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ")
        for(j in input.indices)
            arr[i][j]=input[j].toInt()
    }
    for( i in 0 until n)
        a[i]=i
    var answer=Integer.MAX_VALUE
    while(next())
    {
        var isok=true
        var sum=0
        for(i in 0 until n-1){
            if(arr[a[i]][a[i+1]]==0)
                isok=false
            else
                sum+=arr[a[i]][a[i+1]]
        }
        if(isok && arr[a[n-1]][a[0]]!=0)
        {
            sum+=arr[a[n-1]][a[0]]
            if(answer>sum)
            answer=sum
        }
    }
    println(answer)
}
private fun next():Boolean{
    var i=a.size-1
    while(i>0 && a[i-1] >=a[i])
        i--
    if(i<=0)
        return false
    var j =a.size-1
    while(a[j]<=a[i-1])
        j--
    var tmp=a[i-1]
    a[i-1]=a[j]
    a[j]=tmp
    j=a.size-1
    while(i<j)
    {
        tmp=a[i]
        a[i]=a[j]
        a[j]=tmp
        i++
        j--
    }
    return true
}