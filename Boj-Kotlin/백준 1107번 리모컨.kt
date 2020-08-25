fun main()
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val m=br.readLine().toInt()

    val broken=BooleanArray(10)
    if(m>0) {
        val tmp=br.readLine().split(" ").map { it.toInt() }
        for(i in tmp.indices)
            broken[tmp[i]]=true
    }
    var answer=n-100
    if(answer<0)
        answer=-answer
    for(i in 0 until 1000000)
    {
        val c=i
        val len= go(c,broken)
        if(len>0)
        {
            var press=c-n
            if(press<0)
                press=-press
            if(answer>len+press)
                answer=len+press
        }
    }
    println(answer)
}
fun go(x:Int, broke:BooleanArray):Int{
    if(x==0){
        return when {
            broke[0] -> 0
            else -> 1
        }
    }
    var len=0
    var tmp=x
    while(tmp>0)
    {
        when {
            broke[tmp%10] -> return 0
            else -> {
                len++
                tmp /= 10
            }
        }
    }
    return len
}