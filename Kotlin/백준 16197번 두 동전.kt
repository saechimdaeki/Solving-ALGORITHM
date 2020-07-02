package boj14681kot

private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
private lateinit var arr:Array<Array<Char>>
private var n=0
private var m=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (a,b)=br.readLine().split(" ").map { it->it.toInt() }
    n=a
    m=b
    arr=Array(n){Array(m){' '}}
    for(i in 0 until n)
    {
        val input=br.readLine()
        for(j in input.indices)
            arr[i][j]=input[j]
    }
   var x1=-1
    var y1=-1
    var x2=-1
    var y2=-1
    for(i in 0 until n)
    {
        for( j in 0 until m)
        {
            if(arr[i][j]=='o')
            {
                if(x1==-1)
                {
                    x1=i
                    y1=j
                }else{
                    x2=i
                    y2=j
                }
                arr[i][j]='.'
            }
        }
    }
    println(solve(0,x1,y1,x2,y2))

}
private fun solve(cnt:Int, x1:Int, y1:Int, x2:Int, y2:Int):Int{
    if(cnt==11)
        return -1
    var fall1=false
    var fall2=false
    if(x1<0 || x1>=n || y1<0 ||y1>=m)
        fall1=true
    if(x2<0 || x2>=n ||y2<0 ||y2>=m )
        fall2=true
    if(fall1 && fall2)
        return -1
    if(fall1 || fall2)
        return cnt
    var answer=-1
    for(i in 0 until 4)
    {
        var nextx1=x1+dx[i]
        var nexty1=y1+dy[i]
        var nextx2=x2+dx[i]
        var nexty2=y2+dy[i]
        if(nextx1 in 0 until n && nexty1 in 0 until m && arr[nextx1][nexty1]=='#')
        {
            nextx1=x1
            nexty1=y1
        }
        if(nextx2 in 0 until n && nexty2 in 0 until m &&arr[nextx2][nexty2]=='#')
        {
            nextx2=x2
            nexty2=y2
        }
        var tmp=solve(cnt+1,nextx1,nexty1,nextx2,nexty2)
        //println(tmp)
        if(tmp==-1)
            continue
        if(answer==-1 || answer>tmp)
            answer=tmp
    }
        return answer
}