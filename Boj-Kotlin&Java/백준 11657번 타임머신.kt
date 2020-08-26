private var arr= mutableListOf<Triple<Int,Int,Int>>()
private lateinit var dist:Array<Long>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt()}
    dist=Array(n+1){100000000L}
    for(i in 0 until m)
    {
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        arr.add(Triple(a,b,c))
    }
    dist[1]=0
    var ncycle=false
    for(i in 1..n)
    {
        for(tmp in arr)
        {
            if(dist[tmp.first]!=100000000L&& dist[tmp.second]>dist[tmp.first]+tmp.third)
            {
                dist[tmp.second]=dist[tmp.first]+tmp.third
                if(i==n)
                    ncycle=true
            }
        }
    }
    if(ncycle)
        bw.write("-1\n")
    else{
        for(i in 2..n)
        {
            if(dist[i]==100000000L)
                dist[i]=-1
            bw.write("${dist[i]}\n")
        }
    }
    bw.flush()

}