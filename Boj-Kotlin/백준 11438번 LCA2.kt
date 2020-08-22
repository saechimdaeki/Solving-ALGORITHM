import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:Array<ArrayList<Int>>
private lateinit var depth:Array<Int>
private lateinit var check:Array<Boolean>
private lateinit var parent:Array<Int>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    arr=Array(n+1){ArrayList<Int>()}
    depth=Array(n+1){0}
    check=Array(n+1){false}
    parent=Array(n+1){0}
    repeat(n-1){
        val (a,b)=br.readLine().split(" ").map{it.toInt()}
        arr[a].add(b)
        arr[b].add(a)
    }
    val q=LinkedList<Int>()
    check[1]=true
    depth[1]=0
    parent[1]=0
    q.offer(1)
    while (q.isNotEmpty())
    {
        val cur=q.poll()
        for(i in arr[cur])
        {
            if(!check[i])
            {
                depth[i]=depth[cur]+1
                check[i]=true
                parent[i]=cur
                q.offer(i)
            }
        }
    }
    var log=1
    while (1 shl log <=n)
        log++
    log-=1
    val p=Array(n+1){Array(log+1){0}}
    for(i in 1..n)
        p[i][0]=parent[i]
    var j = 1
    while (1 shl j < n) {
        for (i in 1..n) {
            if (p[i][j - 1] != 0) {
                p[i][j] = p[p[i][j - 1]][j - 1]
            }
        }
        j++
    }
    val m=br.readLine().toInt()
    repeat(m){
        var (x,y)=br.readLine().split(" ").map{it.toInt()}
        if(depth[x]<depth[y])
        {
            val tmp=x
            x=y
            y=tmp
        }
        var log=1
        while (1 shl log<=depth[x])
            log++
        log-=1
        for(i in log downTo 0)
        {
            if(depth[x]- (1 shl i)>=depth[y])
                x=p[x][i]
        }
        if(x==y)
            bw.write("$x\n")
        else{
            for(i in log downTo 0)
            {
                if(p[x][i]!=0 &&p[x][i]!=p[y][i])
                {
                    x=p[x][i]
                    y=p[y][i]
                }
            }
            bw.write("${parent[x]}\n")
        }
    }
    bw.flush()

}