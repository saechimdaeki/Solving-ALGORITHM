private val arraylist= arrayListOf<Int>()
private val visited=Array(10){false}
private val bw=System.out.bufferedWriter()
fun main(args: Array<String>) {
    val (n,m)=System.`in`.bufferedReader().readLine()
            .split(" ").map { it.toInt() }
    for(i in 1 .. n)
        arraylist.add(i)
    backtrack(0,m)
        bw.flush()

}
private fun backtrack(idx:Int,m:Int){
    if(idx==m){
        for(i in 0 until m)
            bw.write("${arraylist[i]} ")
        bw.write("\n")
        return
    }
    for(i in 0 until arraylist.size)
    {
        if(!visited[i]){
            visited[i]=true
            arraylist[idx]=i+1
            backtrack(idx+1,m)
            visited[i]=false
        }
    }

}