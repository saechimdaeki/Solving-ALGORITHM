package 백준
// 우 상 좌 하
private val dx= intArrayOf(1,0,-1,0)
private val dy= intArrayOf(0,-1,0,1)
private val visited=Array(101){BooleanArray(101)}
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    repeat(n){
        var (x,y,d,g)=br.readLine().split(" ").map { it.toInt() }
        val list= arrayListOf<Int>()
        list.add(d)
        for(i in 1..g){
            val tmp=list.size-1
            for(j in tmp downTo 0){
                list.add((list[j]+1)%4)
            }
        }
        visited[y][x]=true
        for(i in list.indices){
            y += dy[list[i]]
            x += dx[list[i]]
            visited[y][x]=true
        }
    }
    var answer=0
    for(i in 0 until 100){
        for(j in 0 until 100){
            if(visited[i][j] && visited[i][j+1] && visited[i+1][j] && visited[i+1][j+1])
                answer++
        }
    }
    println(answer)
}