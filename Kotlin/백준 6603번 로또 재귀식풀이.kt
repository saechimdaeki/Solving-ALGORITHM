package boj14681kot

private lateinit var arr:Array<Int>
private lateinit var result:Array<Int>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    while (true)
    {
        val input=br.readLine().split(" ").map { it->it.toInt() }
        val n=input[0]
        if(n==0)
            break
        arr=Array(n){0}
        result=Array(n){0}
        for(i in 0 until n)
            arr[i]=input[i+1]
        answer(0,0)
        println()
    }

}
private fun answer(idx:Int,cnt:Int){
    if(cnt==6)
    {
        for(i in 0 until result.size)
        {
            if(result[i]==1)
                print("${arr[i]} ")
        }
        println()
        return
    }
    for(i in idx until result.size)
    {
        result[i]=1
        answer(i+1,cnt+1)
        result[i]=0
    }
}