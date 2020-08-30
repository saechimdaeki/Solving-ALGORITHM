package 백준
private lateinit var arr:IntArray
private lateinit var visited:BooleanArray
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,l,r,x)=br.readLine().split(" ").map { it.toInt() }
    visited= BooleanArray(n)
    arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    println("${dfs(0,n,l,r,x)}")
}
private fun dfs(idx:Int,n:Int,l:Int,r:Int,x:Int):Int{
    if(idx==n){
        var (cnt,sum,hard,ez)= intArrayOf(0,0,-1,-1)
        loop@ for(i in 0 until n){
            when {
                !visited[i] -> continue@loop
            }
            sum+=arr[i]
            cnt++
            when {
                hard==-1 || hard<arr[i] -> hard=arr[i]
            }
            when {
                ez==-1 || ez>arr[i] -> ez=arr[i]
            }
        }
        return when {
            cnt>=2 && l<=sum && sum<=r && hard-ez>=x -> 1
            else -> 0
        }
    }
    visited[idx]=true
    val cnt1= dfs(idx+1,n,l,r,x)
    visited[idx]=false
    val cnt2= dfs(idx+1,n,l,r,x)
    return cnt1+cnt2
}