package boj14681kot


private lateinit var arr:Array<Array<Char>>
private lateinit var dist:Array<Array<Int>>
private lateinit var checked:Array<Array<Boolean>>
private val dx= arrayOf(0,0,1,-1)
private val dy= arrayOf(1,-1,0,0)
private var n1=0
private var m1=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val(n,m)=br.readLine().split(" ").map { it->it.toInt() }
    arr=Array(n){Array(m){' '}}
    n1=n
    m1=m
    checked=Array(n){Array(m){false}}
    for(i in 0 until n)
    {
        val input=br.readLine()
        for(j in input.indices)
            arr[i][j]=input[j]
    }

    for( i in 0 until n)
    {
        for( j in 0 until m)
        {
            if(checked[i][j])
                continue
            dist=Array(n){Array(m){0} }
            var isok=dfs(i,j,1,arr[i][j])
            if(isok){
                println("Yes")
                return
            }
        }
    }
    println("No")

}
private fun dfs(x:Int, y:Int, cnt:Int, color:Char):Boolean
{
    if(checked[x][y]){
        return cnt-dist[x][y]>=4
    }
    checked[x][y]=true
    dist[x][y]=cnt
    var tmp=cnt
    for(i in 0 until 4)
    {
        val nextx=x+dx[i]
        val nexty=y+dy[i]
        if(nextx in 0 until n1 && nexty in 0 until m1)
        {
            if(arr[nextx][nexty]==color){
                if(dfs(nextx,nexty,tmp+1,color))
                    return true
            }
        }
    }
    return false
}