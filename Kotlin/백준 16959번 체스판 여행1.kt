import java.util.*

private lateinit var arr:Array<Array<Int>>
private val dx1= intArrayOf(-2,-1,1,2,2,1,-1,-2) 
private val dy1 = intArrayOf(1,2,2,1,-1,-2,-2,-1);

private val dx2= intArrayOf(0,0,1,-1) //
private val dy2= intArrayOf(1,-1,0,0)

private val dx3= intArrayOf(1,1,-1,-1)
private val dy3= intArrayOf(1,-1,1,-1)
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=Array(n){Array(n){0}}
    val dist=Array(n){Array(n){Array(n*n){Array(3){-1} } } }
    val q=LinkedList<node16969>()
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map{it.toInt()}
        for(j in input.indices) {
            arr[i][j] = input[j] - 1
            if(arr[i][j]==0)
            {
                for(k in 0 until 3)
                {
                    dist[i][j][0][k]=0
                    q.offer(node16969(i,j,0,k))
                }
            }
        }
    }
    var answer=-1
    while (q.isNotEmpty())
    {
        val (x,y,num,mal)=q.poll()
        if(num==(n*n)-1){
            if(answer==-1||answer>dist[x][y][num][mal]){
                answer=dist[x][y][num][mal]
            }
        }
        for(i in 0..2){
            if(mal==i) continue
            if(dist[x][y][num][i]==-1){
               dist[x][y][num][i]= dist[x][y][num][mal]+1
                q.offer(node16969(x,y,num,i))
            }
        }
        when (mal) {
            0 -> {
                for(i in 0 until 8) {
                    val nx=x+dx1[i]
                    val ny=y+dy1[i]
                    if(nx in 0 until n && ny in 0 until n){
                        if(arr[nx][ny]==num+1)
                        {
                            if(dist[nx][ny][num+1][mal]==-1){
                                dist[nx][ny][num+1][mal]=dist[x][y][num][mal]+1
                                q.offer(node16969(nx,ny,num+1,mal))
                            }
                        }else{
                            if(dist[nx][ny][num][mal]==-1){
                                dist[nx][ny][num][mal]=dist[x][y][num][mal]+1
                                q.offer(node16969(nx,ny,num,mal))
                            }
                        }
                    }
                }
            }
            1 -> {
                for(i in 0 until 4)
                {
                    var l=1
                    while (true){
                        val nx=x+dx2[i]*l
                        val ny=y+dy2[i]*l
                        if(nx in 0 until n && ny in 0 until n){
                            if(arr[nx][ny]==num+1){
                                if(dist[nx][ny][num+1][mal]==-1){
                                    dist[nx][ny][num+1][mal]=dist[x][y][num][mal]+1
                                    q.offer(node16969(nx,ny,num+1,mal))
                                }
                            }else{
                                if(dist[nx][ny][num][mal]==-1){
                                    dist[nx][ny][num][mal]=dist[x][y][num][mal]+1
                                    q.offer(node16969(nx,ny,num,mal))
                                }
                            }
                        }else
                            break
                        l++
                    }
                }
            }
            else -> {
                for(i in 0 until 4)
                {
                    var l=1
                    while (true){
                        val nx=x+dx3[i]*l
                        val ny=y+dy3[i]*l
                        if(nx in 0 until n && ny in 0 until n){
                            if(arr[nx][ny]==num+1){
                                if(dist[nx][ny][num+1][mal]==-1){
                                    dist[nx][ny][num+1][mal]=dist[x][y][num][mal]+1
                                    q.offer(node16969(nx,ny,num+1,mal))
                                }
                            }else{
                                if(dist[nx][ny][num][mal]==-1){
                                    dist[nx][ny][num][mal]=dist[x][y][num][mal]+1
                                    q.offer(node16969(nx,ny,num,mal))
                                }
                            }
                        }else
                            break
                        l++
                    }
                }
            }
        }
    }
    println(answer)
}
private data class node16969(val x:Int, val y:Int, val num:Int, val mal:Int){
}