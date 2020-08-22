import java.util.*

private lateinit var from:Array<Int>
private lateinit var how:Array<Int>
private lateinit var dist:Array<Int>

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    repeat(t){
        /* 백준센세인강.;.*/
        val n=br.readLine().toInt()
        from=Array(n){-1}
        how=Array(n){-1}
        dist=Array(n){-1}
        val q=LinkedList<Int>()
        q.offer(1%n)
        dist[1%n]=0
        how[1%n]=1
        while (q.isNotEmpty())
        {
            val cur=q.poll()
            for(i in 0 ..1)
            {
                val next=(cur*10+i)%n
                if(dist[next]==-1)
                {
                    dist[next]=dist[cur]+1
                    from[next]=cur
                    how[next]=i
                    q.offer(next)
                }
            }
        }
        if(dist[0]==-1)
            bw.write("BRAK\n")
        else {
            var ans = ""
            var i = 0
            while (i != -1) {
                ans+=how[i].toString()
                i = from[i]
            }
            bw.write("${ans.reversed()}\n")
        }
    }
    bw.flush()
}