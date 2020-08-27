package 백준

private val visited=BooleanArray(10)
private val arr=IntArray(10)
private val bw=System.out.bufferedWriter()
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    dfs(0,1,n,m)
    bw.flush()
}
private fun dfs(idx:Int,start:Int,n:Int,m:Int){
    if(idx==m){
        for(i in 0 until m)
            bw.write("${arr[i]} ")
        bw.write("\n")
        return
    }
    for(i in start..n){
        if(visited[i])
            continue
        visited[i]=true
        arr[idx]=i
        dfs(idx+1,i+1,n,m)
        visited[i]=false
    }
}