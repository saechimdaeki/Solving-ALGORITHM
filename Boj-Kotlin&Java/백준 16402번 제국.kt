package 백준

private lateinit var parent:IntArray
private var index=0
private val map = mutableMapOf<String,Int>()
private val list= arrayListOf<String>()
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    parent= IntArray(n+2){it}
    repeat(n){
        val s=br.readLine()
        list.add(s)
        map[s]=index++
    }
    repeat(m){
        val s=br.readLine()
        val split = s.split(",")
        val a=split[0]
        val b= split[1]
        when (split[2]) {
            "1" -> {
                union(a,b)
            }
            "2" -> {
                union(b,a)
            }
        }
    }
    val answerlist= arrayListOf<String>()
    for(i in 0 until n){
        if(parent[i]==i){
            answerlist.add(list[parent[i]])
        }
    }
    answerlist.sort()
    bw.write("${answerlist.size}\n")
    for (i in answerlist.indices) {
        bw.write("${answerlist[i]}\n")
    }
    bw.flush()
}
private fun find(x:Int):Int{
    return when (x) {
        parent[x] -> x
        else -> {
            parent[x] = find(parent[x])
            parent[x]
        }
    }
}
private fun union(s1:String,s2:String){
    val (px,py)= intArrayOf(find(map[s1]!!), find(map[s2]!!))
    when {
        px!=py -> parent[py]=px
        else -> {
            parent[map[s1]!!]=map[s1]!!
            parent[px]= map[s1]!!
        }
    }
}
