package boj14681kot
private var k=0
private lateinit var arr:Array<ArrayList<Int>>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    k=br.readLine().toInt()
    for(i in 0 until k)
    {
        val (v, e) = br.readLine().split(" ").map { it->it.toInt() }
        arr=Array(v+1){ArrayList<Int>()}
        for(j in 0 until e)
        {
            val (from,to)=br.readLine().split(" ").map { it->it.toInt() }
            arr[from].add(to)
            arr[to].add(from)
        }
        val color=Array(v+1){0}
        var isok=true
        for(j in 1..v)
        {
            if(color[j]==0)
                dfs(arr,color,j,1)
        }
        for(j in 1..v)
        {
            for (k in arr[j])
                if(color[j]==color[k])
                    isok=false
        }
        if(isok)
            bw.write("YES\n")
        else
            bw.write("NO\n")
    }
    bw.flush()
}
private fun dfs(a:Array<ArrayList<Int>>,color:Array<Int>,x:Int,c:Int)
{
    color[x]=c
    for(i in a[x])
    {
        if(color[i]==0)
            dfs(a,color,i,3-c)
    }
}