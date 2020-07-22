private val base=256
private val mod=127
/* 라빈카프 */
fun main() {
    val br=System.`in`.bufferedReader()
    val s=br.readLine()
    val t=br.readLine()
    println(match(s,t))
}
private fun match(s:String,t:String):Int{
    val (n,m)= intArrayOf(s.length,t.length)
    if(n<m)
        return 0
    var hash_p=hash(t)
    var hash_s=hash(s.substring(0,m))
    var first=1
    for(i in 0 until m-1)
        first=(first*base)%mod
    for(i in 0 ..n-m)
    {
        if(hash_p==hash_s)
            if(s.substring(i,i+m) == t)
                return 1
        if(i+m<n)
        {
            hash_s -= (s[i].toInt() * first) % mod
            hash_s=(hash_s+mod)%mod
            hash_s=((hash_s*base)%mod +s[i+m].toInt())%mod
        }
    }
    return 0
}
private fun hash(s:String):Int{
    var answer=0
    for(auto in s)
        answer=(answer*base+auto.toInt())%mod
    return answer
}