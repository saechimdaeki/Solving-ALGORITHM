import java.lang.reflect.Constructor

private var n=0
private var m=0
private lateinit var cctvlist:ArrayList<cctv>
private lateinit var arr:Array<Array<Int>>
private val dx= intArrayOf(0,1,0,-1)
private val dy= intArrayOf(1,0,-1,0)
// 1.각 cctv의 방향 정하기
// 2. 정한 방향에 대해 사각 지대의 크기 구하기
fun main() {
    val br=System.`in`.bufferedReader()
    val nm=br.readLine().split(" ").map { it.toInt() }
    n=nm[0]
    m=nm[1]
    cctvlist= arrayListOf()
    arr=Array(n){Array(m){0}}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
        {
            arr[i][j]=input[j]
            if(input[j] in 1..5)
                cctvlist.add(cctv(i,j,arr[i][j]))
        }
    }
    println(go(arr,cctvlist,0))
}
private fun check(a:Array<Array<Int>>,b:Array<Array<Int>> , x:Int, y:Int , dir:Int){
    var n=a.size
    var m=a[0].size
    var i=x
    var j =y
    while(i in 0 until n && j in 0 until m)
    {
        if(a[i][j]==6)
            break
        b[i][j]=a[x][y]
        i+=dx[dir]
        j+=dy[dir]
    }
}
private fun go(a:Array<Array<Int>>, cct:ArrayList<cctv>, idx:Int):Int{
    if(idx==cct.size)
    {
        var n=a.size
        var m= a[0].size
        val b=Array(n){Array(m){0}}
        for(i in 0 until n)
        {
            for(j in 0 until m)
                b[i][j]=a[i][j]
        }
        for(i in cctvlist)
        {
            var what=i.type
            var x=i.x
            var y=i.y
            var dir=i.dir
            when (what) {
                1 -> check(a,b,x,y,dir)
                2 -> {
                    check(a,b,x,y,dir)
                    check(a,b,x,y,(dir+2)%4)
                }
                3 -> {
                    check(a,b,x,y,dir);
                    check(a,b,x,y,(dir+1)%4);
                }
                4 -> {
                    check(a,b,x,y,dir);
                    check(a,b,x,y,(dir+1)%4);
                    check(a,b,x,y,(dir+2)%4);
                }
                5 -> {
                    check(a,b,x,y,dir);
                    check(a,b,x,y,(dir+1)%4);
                    check(a,b,x,y,(dir+2)%4);
                    check(a,b,x,y,(dir+3)%4);
                }
            }
        }
        var cnt=0
        for(i in 0 until n)
        {
            for( j in 0 until m)
            {
                if(b[i][j]==0)
                    cnt++
            }
        }
        return cnt
    }
    var answer=100
    for(i in 0 until 4)
    {
        cctvlist[idx].dir=i
        var tmp=go(a, cct, idx+1)
        if(answer>tmp)
            answer=tmp
    }
    return answer
}
private class cctv(var x: Int, var y: Int, var type: Int) {
    var dir=0
    init {
        this.dir=0
    }
}

