package 백준
private lateinit var arr:Array<BooleanArray>
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n+1){ BooleanArray(n+1) }
    repeat(m){
        val (a,b)=br.readLine().split(" ").map { it.toInt() }
        arr[a][b]=true
        arr[b][a]=true
    }
    var answer=0
    for(i in 1..n-2){
        for(j in i+1 .. n-1){
            for(k in j+1 .. n){
                if(!arr[i][j] && !arr[j][k] && !arr[k][i])
                    answer++
            }
        }
    }
    println(answer)
}