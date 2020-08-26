import kotlin.system.exitProcess

private lateinit var arr:Array<Array<Int>>
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=Array(n+1){Array(n+1){0}}
   val tmp=Array(n){""}
    for(i in 0 until n)
        tmp[i]=br.readLine()
    for(i in 0 until n){
        for(j in 0 until n){
            if(tmp[i][j]=='Y' && tmp[j][i]=='N')
                arr[i][j]=1
        }
    }
    for(k in 0 until n) {
        for(i in 0 until n){
            for(j in 0 until n){
                if(arr[i][k]==1 && arr[k][j]==1)
                    arr[i][j]=1
            }
        }
    }
    for(i in 0 until n)
    {
        if(arr[i][i]==1){
            println("NO")
            exitProcess(0)
        }
    }
    println("YES")

}