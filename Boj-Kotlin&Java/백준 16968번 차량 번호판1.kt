package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    println("${dfs(br.readLine(),0,' ')}")
}
private fun dfs(s:String,idx:Int,last:Char):Int{
    if(s.length==idx)
        return 1
    val start= if (s[idx]=='c') 'a' else '0'
    val end=if(s[idx]=='c') 'z' else '9'
    var answer=0
    for(i in start..end){
        if(i!=last){
            answer+=dfs(s,idx+1,i)
        }
    }
    return answer
}