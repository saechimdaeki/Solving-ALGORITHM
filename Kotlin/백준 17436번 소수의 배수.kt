fun main() {
    val br=System.`in`.bufferedReader()
    var (a,b)=br.readLine().split(" ")
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val n=a.toInt()
    val m=b.toLong()
    var ans=0L
    for(i in 1 until (1 shl n))
    {
        var cnt=0
        var p=1L
        for(j in 0 until n)
        {
            if((i and (1 shl j))>0)
            {
                p*=arr[j]
                cnt++
                if(p>m){
                    cnt=-1
                    break
                }
            }
        }
        if(cnt==-1)
            continue
        if (cnt%2==0)
            ans-=(m/p)
        else
            ans+=(m/p)
    }
    println(ans)

}