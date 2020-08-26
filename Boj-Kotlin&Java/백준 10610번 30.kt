package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val s=br.readLine()
    var list= arrayListOf<Int>()
    var sum=0
    for(i in s.indices){
        sum+=s[i]-'0'
        list.add(s[i]-'0')
    }
    list.sort()
    if(list[0]==0 && sum%3==0){
        list.reverse()
        for(i in list)
        print(i)
    }else
        println(-1)
}