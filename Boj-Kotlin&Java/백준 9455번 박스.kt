package 백준
private lateinit var arr:Array<IntArray>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    repeat(t){
        val (m,n)=br.readLine().split(" ").map { it.toInt() }
        arr=Array(m){ IntArray(n) }
        for(i in 0 until m){
            val input=br.readLine().split(" ").map { it.toInt() }
            for(j in input.indices){
                arr[i][j]=input[j]
            }
        }
        var answer=0
        for(i in m-1 downTo 0){
            for(j in 0 until n){
                if(arr[i][j]==0 && i!=0){
                    var temp=i-1
                    var check=true
                    var plustmp=1
                    while (true){
                        if(arr[temp][j]==1){
                            arr[temp][j]=0
                            arr[i][j]=1
                            break
                        }
                        temp--
                        if(temp<0){
                            check=false
                            break
                        }
                        plustmp++
                    }
                    if(check){
                        answer+=plustmp
                    }
                }
            }
        }
        println(answer)
    }
}