package 백준

private val dx= intArrayOf(1,1,1)
private val dy= intArrayOf(-1,0,1)
private lateinit var arr:Array<IntArray>
private var answer=0
fun main() {
    val br=System.`in`.bufferedReader()
    val (r,c)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(r){ IntArray(c) }
    for(i in 0 until r){
        val input=br.readLine()
        for(j in input.indices){
            if(input[j]=='.')
                arr[i][j]=0
            else
                arr[i][j]=1
        }
    }
    for(i in 0 until r){
        answer+=dfs(0,i,r,c)
    }
    println(answer)
}
private fun dfs(x:Int,y:Int,r:Int,c:Int):Int{
    arr[y][x]=1
    if(x==c-1) return 1
    for(i in 0 until 3){
        val nx=x+dx[i]
        val ny=y+dy[i]
        if(nx<0 || nx>=c || ny<0 || ny>=r ||arr[ny][nx]==1 ) continue
        if(dfs(nx,ny,r,c)>0) return 1
    }
    return 0
}