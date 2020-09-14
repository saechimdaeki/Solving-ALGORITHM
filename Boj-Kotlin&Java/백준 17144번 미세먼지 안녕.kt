package 백준

private val dx= intArrayOf(1,-1,0,0)
private val dy= intArrayOf(0,0,1,-1)
private lateinit var copyarr:Array<IntArray>
private lateinit var arr:Array<IntArray>
/* 공기 청정기 항상 1번열 두행차지 */
private val air= arrayListOf<Pair<Int,Int>>()
fun main() {
    val br=System.`in`.bufferedReader()
    val (r,c,t)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(r){IntArray(c)}
    for(i in 0 until r){
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices){
            arr[i][j]=input[j]
            if(arr[i][j]==-1){
                air.add(Pair(i,j))
            }
        }
    }
    repeat(t){
        dustGo(r,c)
        airClean(r,c)
    }
    var sum=0
    for(i in 0 until r){
        for(j in 0 until c){
            if(arr[i][j]!=-1)
                sum+=arr[i][j]
        }
    }
/*
    for(i in 0 until r){
        for(j in 0 until c){
            print("${arr[i][j]} ")
        }
        println()
    }
 */
    println("$sum")
}
private fun dustGo(r:Int,c:Int){
    copyarr=Array(r){ IntArray(c) }
    for(i in 0 until r){
        for(j in 0 until c)
            copyarr[i][j]=arr[i][j]
    }
    for(i in 0 until r){
        for(j in 0 until c){
            if(arr[i][j]!=-1 && arr[i][j]!=0){
                var cnt=0
                val value=arr[i][j]
                for(k in 0 until 4){
                    val (nx,ny)= intArrayOf(i+dx[k],j+dy[k])
                    if(nx in 0 until r && ny in 0 until c &&arr[nx][ny]!=-1){
                        copyarr[nx][ny]+=value/5
                        cnt++
                    }
                }
                copyarr[i][j]= copyarr[i][j]-(value/5)*cnt
            }
        }
    }
    for(i in 0 until r){
        for(j in 0 until c)
            arr[i][j]= copyarr[i][j]
    }
}
private fun airClean(r:Int,c:Int){
    for(i in air[0].first-1 downTo 1)
        arr[i][0]=arr[i-1][0]
    for(i in 0 until c-1)
        arr[0][i]=arr[0][i+1]
    for(i in 0 until air[0].first)
        arr[i][c-1]=arr[i+1][c-1]
    for(i in c-1 downTo 1)
        arr[air[0].first][i]=arr[air[0].first][i-1]
    arr[air[0].first][1]=0

    for(i in air[1].first+1 until r-1)
        arr[i][0]=arr[i+1][0]
    for(i in 0 until c-1)
        arr[r-1][i]=arr[r-1][i+1]
    for(i in r-1 downTo air[1].first+1)
        arr[i][c-1]=arr[i-1][c-1]
    for(i in c-1 downTo 1)
        arr[air[1].first][i]=arr[air[1].first][i-1]
    arr[air[1].first][1]=0
}

