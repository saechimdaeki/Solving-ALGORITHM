package 백준

private val arr=Array(5){Array(5){""} }
private val set=HashSet<String>()
private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
fun main() {
    val br=System.`in`.bufferedReader()
    for(i in 0 until 5){
        val input=br.readLine().split(" ")
        for(j in input.indices){
            arr[i][j]=input[j]
        }
    }
    for(i in 0 until 5){
        for(j in 0 until 5){
            dfs(i,j,arr[i][j],1)
        }
    }
    println(set.size)

}
private fun dfs(x:Int,y:Int,number:String,length:Int){
    if(length==6){
        set.add(number)
        return
    }
    for(i in 0 until 4){
        val nx=x+dx[i]
        val ny=y+dy[i]
        if(nx in 0 until 5 && ny in 0 until 5)
            dfs(nx,ny,number+arr[nx][ny],length+1)
    }
}