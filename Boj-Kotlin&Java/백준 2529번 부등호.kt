package 백준

private lateinit var arr:Array<String>
private val list= arrayListOf<String>()
private val visited=BooleanArray(10)
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=br.readLine().split(" ").toTypedArray()
    dfs(0,"",n)
    list.sort()
    println(list[list.size-1])
    println(list[0])
}
private fun dfs(idx:Int,number:String,n:Int){
    if (idx==n+1){
        list.add(number)
        return
    }
    for(i in 0 ..9){
        if(visited[i]) continue
        if(idx==0 || check(number[idx-1],(i + '0'.toInt()).toChar(),arr[idx-1])){
            visited[i]=true
            dfs(idx+1,number+i.toString(),n)
            visited[i]=false
        }
    }
}
private fun check(x:Char,y:Char,operation:String):Boolean{
    return when {
        operation=="<" && x>y -> false
        operation==">" && x<y -> false
        else -> true
    }
}