package 백준
private lateinit var arr:Array<String>
private val set= mutableSetOf<Int>()
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,k)=br.readLine().split(" ").map { it.toInt() }
    arr=br.readLine().split(" ").toTypedArray()
    arr.sort()
    dfs("",n)
    val tmp= arrayListOf<Int>()
    tmp.addAll(set)
    println(tmp.max())
}
private fun dfs(number:String,n:Int){
    if(number!="") {
        if (number.toInt() > n) return
        if (number.toInt() <= n) {
            set.add(number.toInt())
        }
    }
    for(i in arr.indices){
        dfs(number+arr[i],n)
    }
}