import java.util.*

private lateinit var arr:Array<Array<Int>>
private lateinit var degree:Array<Int>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    repeat(t){
        val n=br.readLine().toInt()
        val input=br.readLine().split(" ").map { it.toInt() }
        arr=Array(n+1){Array(n+1){0}}
        degree=Array(n+1){0}
        for(i in 0 until n){
            for(j in i+1 until n){
                arr[input[i]][input[j]]=1
                degree[input[j]]++
            }
        }
        val change=br.readLine().toInt()
        repeat(change){
            val (a,b)=br.readLine().split(" ").map { it.toInt() }
            if(arr[a][b]==1) {
                arr[a][b] = 0
                arr[b][a] = 1
                degree[b]--
                degree[a]++
            }else{
                arr[b][a]=0
                arr[a][b]=1
                degree[a]--
                degree[b]++
            }
        }
        val q=LinkedList<Int>()
        for(i in 1..n){
            if(degree[i]==0)
                q.offer(i)
        }
        var check=true
        val answerlist= arrayListOf<Int>()
        loopwhile@while (q.isNotEmpty()){
            if(q.size>1){
                check=false
                break@loopwhile
            }
            val cur=q.poll()
            answerlist.add(cur)
            for(i in 1..n){
                if(arr[cur][i]==1)
                {
                    degree[i]--
                    if(degree[i]==0)
                        q.offer(i)
                }
            }
        }
        if(!check)
            bw.write("?")
        else if(answerlist.size==n)
        {
            for(i in answerlist)
                bw.write("$i ")
        }else{
            bw.write("IMPOSSIBLE")
        }
        bw.write("\n")
    }
    bw.flush()
}