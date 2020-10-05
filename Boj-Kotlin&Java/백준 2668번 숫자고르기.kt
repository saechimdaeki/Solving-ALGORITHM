package 백준
private val answerList= arrayListOf<Int>()
private val arr= arrayListOf<Pair<Int,Int>>()
private lateinit var visited:BooleanArray
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    arr.add(Pair(0,0))
    for(i in 1 .. n){
        arr.add(Pair(i,br.readLine().toInt()))
    }
    visited= BooleanArray(n+1)
    visited[0]=true //always
    for(i in 1.. n){
        visited[i]=true
        dfs(i,i)
        visited[i]=false
    }
    answerList.sort()
    println(answerList.size)
    for(i in answerList){
        println("$i")
    }
}
private fun dfs(startnum:Int,x:Int){
    if(startnum==arr[x].second) answerList.add(x)
    if(!visited[arr[x].second]){
        visited[arr[x].second]=true
        dfs(startnum,arr[x].second)
        visited[arr[x].second]=false
    }
}