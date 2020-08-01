fun main() {
    var s=System.`in`.bufferedReader().readLine()
    val bw=System.out.bufferedWriter()
    if(s.length%3==1)
        s= "00$s"
    else if(s.length%3==2)
        s="0$s"
    for(i in s.indices step 3)
        bw.write("${(s[i]-'0')*4 + (s[i+1]-'0')*2 +(s[i+2]-'0')}")
    bw.flush()
}