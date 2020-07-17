private lateinit var nan2do:IntArray
private lateinit var checked:Array<Boolean>
fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val (n,l,r,x)=br.readLine().split(" ").map {it.toInt()}
     nan2do=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    checked=Array(n){false}
    println(bruteForce(0,n,l,r,x))
}
private fun bruteForce(idx:Int, n1:Int, l1:Int, r1:Int, x1:Int):Int{
    if(idx==n1)
    {
        var (cnt,sum,hard,easy)= intArrayOf(0,0,-1,-1)
        for(i in 0 until n1)
        {
            if(!checked[i])
                continue
            sum+=nan2do[i]
            cnt++
            if(hard==-1||hard<nan2do[i])
                hard=nan2do[i]
            if(easy==-1||easy>nan2do[i])
                easy=nan2do[i]
        }
        return if(cnt>=2 && sum in l1..r1 &&hard-easy>=x1)
            1
        else
            0
    }

    checked[idx]=true
    var cnt1=bruteForce(idx+1, n1, l1, r1, x1)
    checked[idx]=false
    var cnt2=bruteForce(idx+1, n1, l1, r1, x1)
    return cnt1+cnt2
}