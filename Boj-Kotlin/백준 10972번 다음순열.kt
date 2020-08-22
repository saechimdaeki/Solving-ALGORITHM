package boj14681kot



private var n=0
private lateinit var arr:Array<Int>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    n=br.readLine().toInt()
    arr=Array<Int>(n){0}
    val input=br.readLine().split(" ")
    for(i in 0 until n)
        arr[i]=input[i].toInt()
        if (nextPermutation()) {
            for (i in 0 until n)
                print("${arr[i]} ")
            println()
        } else
            println("-1")

}
private fun nextPermutation():Boolean{
    var i=arr.size-1
    while(i>0 && arr[i-1] >=arr[i])
        i-=1
    if(i<=0)
        return false
    var j = arr.size-1
    while(arr[j] <= arr[i-1])
        j-=1

    var tmp=arr[i-1]
    arr[i-1]=arr[j]
    arr[j]=tmp
    j= arr.size-1
    while(i<j)
    {
        tmp=arr[i]
        arr[i]= arr[j]
        arr[j]=tmp
        i+=1
        j-=1
    }
    return true

}
