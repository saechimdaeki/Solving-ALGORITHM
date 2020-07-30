private lateinit var dist:Array<Int>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var tc=br.readLine().toInt()
    while (tc-- >0)
    {
        val (n,m,w)=br.readLine().split(" ").map { it.toInt() }
        dist=Array(n+1){0}

        var arr= mutableListOf<Triple<Int,Int,Int>>()
        for(i in 0 until m)
        {
            val (s,e,t)=br.readLine().split(" ").map { it.toInt() }
            arr.add(Triple(s,e,t))
            arr.add(Triple(e,s,t)) //여기를 더해야하는건 백준질문게시판을 봤습니다 아직 이해는안되는
        }
        for(i in 0 until w)
        {
            val (s,e,t)=br.readLine().split(" ").map { it.toInt() }
            arr.add(Triple(s,e,-t))
        }
        var cycle=false
        for(i in 1..n)
        {
            for(tmp in arr)
            {
                if(dist[tmp.second]!=100000000 &&dist[tmp.second]>dist[tmp.first]+tmp.third)
                {
                  dist[tmp.second]=dist[tmp.first]+tmp.third
                    if(i==n)
                    cycle=true
                }
            }
        }
        if(cycle)
            bw.write("YES\n")
        else
            bw.write("NO\n")
    }
    bw.flush()
}