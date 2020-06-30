package boj14681kot
val track14002=Array(1001){0}
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val input=br.readLine().split(" ")
    val arr=ArrayList<Int>()

    val dp=Array(n+1){0}
    for(s in input)
        arr.add(s.toInt())
    for(i in 0 until n)
    {
        dp[i]=1
        track14002[i]=-1
        for(j in 0 until i)
        {
            if(arr[j]<arr[i] && dp[j]+1>dp[i]){
                dp[i]=dp[j]+1
                track14002[i]=j
            }
        }
    }
    var answer=dp[0]
    var cnt:Int=0
    for (i in 0 until n step 1)
    {
        if(answer<dp[i]){
            answer=dp[i]
            cnt=i
        }
    }
    println(dp.max())
    backtrack(cnt,arr)
}
fun backtrack(n1:Int,arrlist:ArrayList<Int>){
    if(n1==-1)
        return
    backtrack(track14002[n1],arrlist)
    print("${arrlist[n1]} ")
}