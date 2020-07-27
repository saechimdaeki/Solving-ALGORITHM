import kotlin.math.max

fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map {it.toInt()}
    val arr=Array(n+1){Array(m+1){0}}
    val dynamic=Array(n+1){Array(m+1){0}}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
            arr[i+1][j+1]=input[j]
    }

    var answer=0
    for(i in 1..n)
    {
        for(j in 1..m)
        {
            answer= max(max(dynamic[i-1][j-1],dynamic[i-1][j]),dynamic[i][j-1])
            dynamic[i][j]=answer+arr[i][j]
        }
    }
    println("${dynamic[n][m]}")

}