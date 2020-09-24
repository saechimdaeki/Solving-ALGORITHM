package 백준

fun main() {
    val s= readLine()!!.split(" ")
    val bw=System.out.bufferedWriter()
    val tmp=s[0]
    for(i in 1 until s.size){
        var tmps=""
        var keeps=" "
       for(j in s[i].length-1 downTo 0){
            if(s[i][j]==','||s[i][j]==';') continue
            if(s[i][j] in 'a'..'z' || s[i][j] in 'A'..'Z')
                keeps+=s[i][j]
            else if(s[i][j]=='[')
            tmps+=']'
            else if(s[i][j]==']')
            tmps+='['
            else
                tmps+=s[i][j]
       }
        keeps=keeps.reversed()
        keeps=keeps.substring(0,keeps.length-1)
        bw.write("${"$tmp${tmps} ${keeps};"}\n")
    }
    bw.flush()
}