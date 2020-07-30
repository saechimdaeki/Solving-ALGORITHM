private lateinit var arr:Array<ArrayList<Pair<Int,Int>>>
private lateinit var dist:Array<Int>
private lateinit var check:Array<Boolean>
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    var m=br.readLine().toInt()
    arr=Array(n+1){ArrayList<Pair<Int,Int>>()}
    for(i in 0 until m)
    {
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        arr[a].add(Pair(b,c))
    }
    val (start,end)=br.readLine().split(" ").map { it.toInt() }
    dist=Array(n+1){ 1000000000}
    check= Array(n+1){false}
    dist[start]=0
    for(i in 0 until n-1)
    {
        m=1000000000+1
        var x=-1
        for(j in 1..n)
        {
            if(!check[j] && m>dist[j])
            {
                m=dist[j]
                x=j
            }
        }
        check[x]=true
        for(tmp in arr[x])
        {
            if(dist[tmp.first]>dist[x]+tmp.second)
                dist[tmp.first]=dist[x]+tmp.second
        }
    }
    println(dist[end])
}