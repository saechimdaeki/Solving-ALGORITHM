import kotlin.system.exitProcess

private lateinit var uncheck:Array<Array<Boolean>>
private lateinit var arr:Array<Array<Int>>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n =br.readLine().toInt()
    arr=Array(n){Array(n){0}}
    uncheck=Array(n){Array(n){false}}
    for(i in 0 until n) {
        val input = br.readLine().split(" ").map { it.toInt() }
        for (j in input.indices)
            arr[i][j]=input[j]
    }
    for(i in 0 until n)
    {
        for(j in 0 until n)
        {
            if(i==j) continue
            for(k in 0 until n)
            {
                if(j==k) continue
                if(i==k) continue
                if(arr[j][k]>arr[j][i]+arr[i][k]){
                    println(-1)
                    exitProcess(0)
                }
                if(arr[j][k]==arr[j][i]+arr[i][k]){
                    uncheck[j][k]=true
                }
            }
        }
    }
    var answer=0
    for(i in 0 until n)
    {
        for(j in 0 until n)
        {
            if(!uncheck[i][j])
                answer+=arr[i][j]
        }
    }
    println(answer/2)
}