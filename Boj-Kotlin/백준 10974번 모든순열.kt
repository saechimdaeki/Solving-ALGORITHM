package boj14681kot



private lateinit var arr:ArrayList<Int>
private var n=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    n=br.readLine().toInt()
    arr= ArrayList()
    for(i in 1..n)
        arr.add(i)
    for(i in arr)
        bw.write("$i ")
    bw.write("\n")
    while(next()){
        for (i in arr)
            bw.write("$i ")
        bw.write("\n")
    }
    bw.flush()
}
private fun next():Boolean{
    var i=arr.size-1
    while ( i>0 && arr[i-1] >= arr[i])
        i--
    if(i<=0)
        return false
    var j =arr.size-1
    while (arr[j]<=arr[i-1])
        j--
    var tmp=arr[i-1]
    arr[i-1]=arr[j]
    arr[j]=tmp
    j=arr.size-1
    while(i<j)
    {
        tmp=arr[i]
        arr[i]=arr[j]
        arr[j]=tmp
        i++
        j--
    }
    return true
}