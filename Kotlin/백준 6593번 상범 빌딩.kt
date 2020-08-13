import java.util.*

private lateinit var arr:Array<Array<Array<Char>>>
private lateinit var check:Array<Array<Array<Boolean>>>
private val dx= intArrayOf(-1,0,1,0,0,0)
private val dy= intArrayOf(0,1,0,-1,0,0)
private val dz= intArrayOf(0,0,0,0,1,-1)

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    whileloop@while (true)
    {
        val (l,r,c)=br.readLine().split(" ").map { it.toInt() }
        if(l==0)
            break@whileloop
        arr=Array(l){Array(r){Array(c){' '} } }
        check=Array(l){Array(r){Array(c){false} } }
        val q=LinkedList<sangbum>()
        var maincnt=0
        for(i in 0 until l)
        {
            for(j in 0 until r)
            {
                val input=br.readLine()
                for(k in input.indices)
                {
                    arr[i][j][k]=input[k]
                    if(arr[i][j][k]=='S')
                    {
                        q.offer(sangbum(i,j,k,0))
                    }
                }
            }
            br.readLine()
        }
        qwhile@while (q.isNotEmpty())
        {
            var(z,x,y,cnt)=q.poll()
            for(i in 0 until 6)
            {
               val nz=z+dz[i]
                val nx=x+dx[i]
                val ny=y+dy[i]
                if(nx<0||ny<0||nz<0 || nx>=r || ny>=c ||nz>=l)
                    continue
                if(arr[nz][nx][ny]=='.' && !check[nz][nx][ny])
                {
                    check[nz][nx][ny]=true
                    q.offer(sangbum(nz,nx,ny,cnt+1))
                }else if(arr[nz][nx][ny]=='E')
                {
                    maincnt++
                    cnt++
                    bw.write("Escaped in $cnt minute(s).\n")
                    break@qwhile
                }
            }
        }
        if(maincnt==0)
            bw.write("Trapped!\n")
    }
    bw.flush()
}
private data class sangbum(var z:Int,var x:Int,var y:Int, var cnt:Int)