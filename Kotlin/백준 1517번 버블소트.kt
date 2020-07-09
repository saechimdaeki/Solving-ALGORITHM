private lateinit var arr:IntArray
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    println(bubblesort(arr,0,n-1))
}

private fun bubblesort(array:IntArray,start:Int,end:Int):Long{
    if(start==end)
        return 0
    var mid=(start+end)/2
    var tmparray=Array(end-start+1){0}
    var answer= bubblesort(array,start,mid) + bubblesort(array,mid+1,end)
    var i =start
    var j =mid+1
    var k=0
    while(i<=mid || j <=end)
    {
        if(i<=mid && (j>end||array[i]<=array[j]))
            tmparray[k++]=array[i++]
        else
        {
            answer+=(mid-i+1).toLong()
            tmparray[k++]=array[j++]
        }
    }
    for(i in start .. end)
        array[i]=tmparray[i-start]
    return answer
}