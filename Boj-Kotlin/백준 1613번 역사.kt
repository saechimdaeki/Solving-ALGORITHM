import java.util.*

private lateinit var arr:Array<Array<Int>>
private lateinit var degree:Array<Int>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,k1)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n+1){Array(n+1){0}}
    degree=Array(n+1){0}
    repeat(k1){
        val (a,b)=br.readLine().split(" ").map{it.toInt()}
        arr[a][b]=1
    }
    for(k in 1..n){
        for(i in 1..n){
            for(j in 1..n){
                if(arr[i][k] ==1 && arr[k][j]==1)
                    arr[i][j]=1
            }
        }
    }
    val s=br.readLine().toInt()
    repeat(s){
        val (x,y)=br.readLine().split(" ").map { it.toInt() }
        if(arr[x][y]==1 && arr[y][x]==0)
            bw.write("-1\n")
        else if(arr[x][y]==0 && arr[y][x]==1)
            bw.write("1\n")
        else
            bw.write("0\n")
    }
    bw.flush()

}