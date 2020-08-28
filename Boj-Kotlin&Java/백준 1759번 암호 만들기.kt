package 백준

private val bw=System.out.bufferedWriter()
private lateinit var arr:Array<String>
fun main() {
    val br=System.`in`.bufferedReader()
    val (l,c)=br.readLine().split(" ").map { it.toInt() }
    arr=br.readLine().split(" ").toTypedArray()
    arr.sort()
    dfs(l,arr,"",0)
    bw.flush()
}
private fun dfs(l:Int,arr:Array<String>,pwd:String,idx:Int){
    if(pwd.length==l){
        if(check(pwd))
            bw.write("$pwd\n")
        return
    }
    if(idx>=arr.size) return
    dfs(l,arr,pwd+arr[idx],idx+1)
    dfs(l,arr,pwd,idx+1)
}
private fun check(pwd:String):Boolean{
    var (jaum,moum)= intArrayOf(0,0)
    for(i in pwd){
        when (i) {
            'a', 'e', 'i', 'o', 'u' -> moum++
            else -> jaum++
        }
    }
    return jaum>=2 && moum>=1
}