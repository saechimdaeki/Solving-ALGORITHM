package 백준

private lateinit var arr:IntArray
private lateinit var dp:Array<IntArray>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    repeat(t){
        val n=br.readLine().toInt()
        dp=Array(n+1){ IntArray(n+1){-1} }
        arr= IntArray(n+1)
        val input=br.readLine().split(" ").map { it.toInt() }
        for(i in 1 .. n)
            arr[i]=input[i-1]
        bw.write("${dfs(1,n)}\n")
    }
    bw.flush()
}
private fun dfs(idx:Int,n:Int):Int{
    if(idx==n) return 0
    if(dp[idx][n]!=-1) return dp[idx][n]
    var answer=-1
    var sum=0
    for(i in idx..n)
        sum+=arr[i]
    for(i in idx until n){
        val tmp=dfs(idx,i)+dfs(i+1,n)+sum
        if(answer==-1 || answer>tmp)
            answer=tmp
    }
    dp[idx][n]=answer //memo
    return answer
}