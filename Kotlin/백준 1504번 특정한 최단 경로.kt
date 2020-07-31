private lateinit var arr:Array<Array<Int>>
private lateinit var dist:Array<Int>
private const val inf=100000000
private lateinit var checked:Array<Boolean>
fun main() {

    val br=System.`in`.bufferedReader()
    val (n,e)=br.readLine().split(" ").map{it.toInt()}
    val answerlist= arrayListOf<Int>()
    arr=Array(n+1){Array(n+1){inf}}
    dist=Array(n+1){inf}
    checked=Array(n+1){false}
    repeat(e){
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        if(arr[a][b]>c)
            arr[a][b]=c
        if(arr[b][a]>c)
            arr[b][a]=c
    }
    val (v1,v2)=br.readLine().split(" ").map { it.toInt() }
    val onestart=dijkstra(1,n)
    val v1start=dijkstra(v1,n)
    val v2start=dijkstra(v2,n)

    answerlist.add(onestart[v1]+v1start[v2]+v2start[n])
    answerlist.add(onestart[v2]+v1start[n]+v2start[v1])
    println(if(answerlist.min()!!>=inf) "-1" else answerlist.min())

}
private fun dijkstra(n1:Int,n:Int):IntArray{
    checked.fill(element = false)
    dist.fill(element = inf)
    dist[n1]=0
    for(i in 0 until n-1)
    {
        var tmpm=inf+1
        var x=-1
        for(j in 1..n)
        {
            if(!checked[j] && tmpm>dist[j])
            {
                tmpm=dist[j]
                x=j
            }
        }
        checked[x]=true
        for(j in 1..n)
        {
            if(dist[j]>dist[x]+arr[x][j])
                dist[j]=dist[x]+arr[x][j]
        }
    }
    return dist.toIntArray()

}