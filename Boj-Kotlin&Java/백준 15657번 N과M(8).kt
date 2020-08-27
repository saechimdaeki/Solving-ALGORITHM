package 백준

private val bw=System.out.bufferedWriter()
private lateinit var arr:IntArray
private lateinit var answer:IntArray
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    arr.sort()
    answer= IntArray(n)
    dfs(0,0,n,m)
    bw.flush()
}
private fun dfs(idx:Int,start:Int,n:Int,m:Int){
    if(idx==m){
        for(i in 0 until m)
            bw.write("${answer[i]} ")
        bw.write("\n")
        return
    }
    for(i in start until n){
        answer[idx]=arr[i]
        dfs(idx+1,i,n,m)
    }

}