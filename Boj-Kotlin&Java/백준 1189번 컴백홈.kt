package 백준

private lateinit var arr:Array<Array<Char>>
private lateinit var visited:Array<BooleanArray>
private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
private var answer=0
fun main() {
    val br=System.`in`.bufferedReader()
    val (r,c,k)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(r+1){Array(c+1){' '}}
    visited=Array(r+1){ BooleanArray(c+1) }
    for(i in 1..r){
        val input=br.readLine()
        for(j in 1..c)
            arr[i][j]=input[j-1]
    } //왼쪽아래점시작
    visited[r][1]=true
    dfs(r,1,1,r,c,k)
    println(answer)
}
private fun dfs(x:Int,y:Int,dist:Int,r:Int,c:Int,k:Int){
    if(x==1 && y==c){
        if(dist==k)
            answer++
        return
    }
    for(i in 0 until 4){
        val nx=x+dx[i]
        val ny=y+dy[i]
        if(nx in 1..r && ny in 1..c){
            if(!visited[nx][ny] && arr[nx][ny]=='.'){
                visited[nx][ny]=true
                dfs(nx,ny,dist+1,r,c,k)
                visited[nx][ny]=false
            }
        }
    }
}