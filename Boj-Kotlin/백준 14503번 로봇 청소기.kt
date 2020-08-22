import java.util.*

private lateinit var arr:Array<Array<Int>>
private lateinit var check:Array<Array<Boolean>>
private val dx= intArrayOf(-1,0,1,0)
private val dy= intArrayOf(0,1,0,-1)
private var answer=0
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val (r,c,d)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n){Array(m){0}}
    check=Array(n){Array(m){false}}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    bfs(r,c,d,n,m)
    println(answer+1)
}
private fun bfs(r:Int,c:Int,d:Int,n:Int,m:Int){
    val q=LinkedList<Triple<Int,Int,Int>>()
    q.offer(Triple(r,c,d))
    check[r][c]=true

    while (q.isNotEmpty())
    {
        var (x,y,nowd)=q.poll()
        var flag=false
        var nextd=nowd
        for(i in 0 until 4)
        {
            nextd=turnleft(nextd)
            val (nx,ny)= intArrayOf(x+dx[nextd],y+dy[nextd])
            if(nx in 0 until n && ny in 0 until m)
            {
                if(arr[nx][ny]==0 && !check[nx][ny])
                {
                    check[nx][ny]=true
                    q.offer(Triple(nx,ny,nextd))
                    answer++
                    flag=true
                    break
                }
            }
        }
        if(!flag)
        {
            nextd=turnb(nowd)
            val (nx,ny)= intArrayOf(x+dx[nextd],y+dy[nextd])
            if(nx in 0 until n && ny in 0 until m)
            {
                if(arr[nx][ny]==0)
                    q.offer(Triple(nx,ny,nowd))
            }
        }
    }

}
private fun turnleft(d:Int):Int{
    return when(d){
        0 -> 3
        1 -> 0
        2 -> 1
        else -> 2
    }
}
private fun turnb(d:Int):Int{
    return when(d){
        0 -> 2
        1->3
        2->0
        else ->1
    }
}