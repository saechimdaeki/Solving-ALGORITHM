package boj14681kot

fun main(args:Array<String>)
{
    var cnt=0
    var time=0
    val br=System.`in`.bufferedReader()
    val (N,m, M ,T,R)=br.readLine().split(" ").map { it->it.toInt() }
    var now=m
    while(true) {
        if(cnt==N)
           break
        if(m+T>M)
        {
            time=-1
            break
        }
        if (now + T <= M) {
            cnt++
            time++
            now += T
        } else {
            time++
            now -= R
            if (now < m)
                now = m
        }
    }
    println(time)

}