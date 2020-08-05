fun main() {
    val br=System.`in`.bufferedReader()
    val s=br.readLine()
    var face=false
    var right=0
    var left=0
    for(i in s.indices)
    {
        if(s[i]=='0')
            face=true
        if(!face) {
            if (s[i] == '@')
                right++
        }else{
            if(s[i]=='@')
                left++
        }
    }
    println("$right $left")
}