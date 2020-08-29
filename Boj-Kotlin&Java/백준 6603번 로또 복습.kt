package 백준

private lateinit var arr:IntArray
private lateinit var visited:BooleanArray
private val bw=System.out.bufferedWriter()
fun main() {
    val br=System.`in`.bufferedReader()
    while (true){
        val input=br.readLine().split(" ").map { it.toInt() }
        val k=input[0]
        if(k==0)
            break
        arr=input.subList(1,input.size).toIntArray()
        visited= BooleanArray(k)
        dfs(0,0)
        bw.write("\n")
    }
    bw.flush()
}
private fun dfs(idx:Int,count:Int){
    if(count==6){
        for(i in arr.indices){
            if(visited[i])
                bw.write("${arr[i]} ")
        }
        bw.write("\n")
        return
    }
    for(i in idx until arr.size){
        visited[i]=true
        dfs(i+1,count+1)
        visited[i]=false
    }
}