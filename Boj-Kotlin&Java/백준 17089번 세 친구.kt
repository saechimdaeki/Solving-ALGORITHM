package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val friend=Array(n+1){BooleanArray(n+1)}
    val degree=IntArray(n+1){0}
    repeat(m){
        val (a,b)=br.readLine().split(" ").map { it.toInt() }
        friend[a][b]=true
        friend[b][a]=true
        degree[a]++
        degree[b]++
    }
    var answer=-1
    for(i in 1..n){
        for(j in 1..n){
            if(friend[i][j]){
                for(k in 1..n){
                    if(friend[i][k]&& friend[j][k]){
                        val sum=degree[i]+degree[j]+degree[k]-6
                        if(answer==-1 ||answer>sum)
                            answer=sum
                    }
                }
            }
        }
    }
    println(answer)
}