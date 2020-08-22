package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it->it.toInt() }
    val list=ArrayList<Int>()
    for(i in 0 until n)
    {
        var tmp=arr[i]
        var sum=0
        for(j in i+1 until n)
        {
            if(tmp<arr[j] && arr[j-1]<arr[j])
                sum=arr[j]-tmp
            else {
                break
            }
        }
        list.add(sum)
    }
    println(list.max())
}