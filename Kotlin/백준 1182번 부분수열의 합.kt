package boj14681kot

private var answer=0
private lateinit var arr:Array<Int>
private var n=0
private var k=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val input=br.readLine().split(" ").map { it->it.toInt() }
     n=input[0]
    k=input[1]
    arr=Array(n){0}
    val arrinput=br.readLine().split(" ").map { it->it.toInt() }
    for(i in 0 until n)
        arr[i]=arrinput[i]
    dfs(0,0)
    if(k==0)
        answer-=1
    println(answer)
}
private fun dfs(idx:Int,sum:Int){
    if(idx==n)
    {
        if(sum==k)
            answer++
        return
    }
    dfs(idx+1,sum+arr[idx])
    dfs(idx+1,sum)

}