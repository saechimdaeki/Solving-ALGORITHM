import java.util.*

private lateinit var arr:Array<Array<Char>>
private lateinit var dist:Array<Array<Array<Array<Int>>>>
private val dx= intArrayOf(1,-1,0,0)
private val dy= intArrayOf(0,0,1,-1)
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map{it.toInt()}
    arr=Array(n){Array(m){' '}}
    dist=Array(n){Array(m){Array(4){Array(4){-1}}}}
    for(i in 0 until n)
    {
        val input=br.readLine()
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    var (answer,x1,y1,x2,y2)= intArrayOf(-1,-1,-1,-1,-1)
    val q=LinkedList<nodeBaeDal>()
    for(i in 0 until n)
    {
        for(j in 0 until m)
        {
            if(arr[i][j]=='S') {
                for (k in 0 until 4) {
                    q.offer(nodeBaeDal(i, j, k, 0))
                    dist[i][j][k][0] = 0
                }
            }else if(arr[i][j]=='C'){
                if(x1==-1){
                    x1=i
                    y1=j
                }else{
                    x2=i
                    y2=j
                }
            }
        }
    }

    while (q.isNotEmpty())
    {
       val (x,y,dir,s)=q.poll()
        if(s==3){
            answer=dist[x][y][dir][s]
            break
        }
        for(i in 0 until 4)
        {
            if(dir==i)
                continue
            var nx=x+dx[i]
            var ny=y+dy[i]
            if(nx in 0 until n && ny in 0 until m)
            {
                if(arr[nx][ny]!='#'){
                    var ns=s
                    if(arr[nx][ny]=='C'){
                        ns = if(nx==x1 && ny==y1){
                            ns or 1
                        }else
                            ns or 2
                    }
                    if(dist[nx][ny][i][ns]==-1){
                        dist[nx][ny][i][ns]=dist[x][y][dir][s]+1
                        q.offer(nodeBaeDal(nx,ny,i,ns))
                    }
                }
            }
        }
    }
    println(answer)
}
private data class nodeBaeDal(var x: Int, var y: Int, var dir: Int, var s: Int) {
}