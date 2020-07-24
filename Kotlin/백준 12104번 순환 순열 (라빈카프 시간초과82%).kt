private val base=1024
private val mod=4349
fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val a=br.readLine()
    val b=br.readLine()
    var tmp=b+b
    tmp=tmp.substring(0,tmp.length-1)
    val answer=match(tmp,a)
    println(answer)
}
private fun match(s:String,t:String):Int{
    var answer=0
    val (n,m)= intArrayOf(s.length,t.length)
    if(n<m)
        return answer
    var hash_p=hash(t)
    var hash_s=hash(s.substring(0,m))
    var first=1
    for(i in 0 until m-1)
        first=(first*base)%mod
    for(i in 0 ..n-m)
    {
        if(hash_p==hash_s)
            if(s.substring(i,i+m) == t)
                answer++
        if(i+m<n)
        {
            hash_s -= (s[i].toInt() * first) % mod
            hash_s=(hash_s+mod)%mod
            hash_s=((hash_s*base)%mod +s[i+m].toInt())%mod
        }
    }
    return answer
}
private fun hash(s:String):Int{
    var answer=0
    for(auto in s)
        answer=(answer*base+auto.toInt())%mod
    return answer
}