package boj14681kot

private var answer=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    var (n,k)=br.readLine().split(" ").map { it->it.toInt() }
    val arr=ArrayList<Int>()
    for(i in 0 until n)
        arr.add(br.readLine().toInt())
    arr.sortDescending()
    for(i in 0 until n)
    {
        answer+=k/arr[i]
        k%=arr[i]
    }
    println(answer)
}