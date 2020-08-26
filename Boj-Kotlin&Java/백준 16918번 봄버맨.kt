
private val dx= intArrayOf(1,-1,0,0)
private val dy= intArrayOf(0,0,1,-1)
private lateinit var arr:Array<Array<Int>>
private lateinit var charr:Array<Array<Char>>


fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (r,c,n)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(r){Array(c){0}}
    charr=Array(r){Array(c){' '}}
    for(i in 0 until r)
    {
        val input=br.readLine()
        for(j in input.indices)
        {
            charr[i][j]=input[j]
        }
    }
    for(i in 0 until r)
    {
        for(j in 0 until c)
            if(charr[i][j]=='O')
                arr[i][j]=3
    }
    for(i in 1 .. n)
    {
        bomb(i,r,c)
        if(i%2==0)
            setbomb(i,r,c)
    }
    for(i in 0 until r)
    {
        for(j in 0 until c)
            bw.write("${charr[i][j]}")
        bw.write("\n")
    }
    bw.flush()
}
private fun bomb(time:Int,r:Int,c:Int){
    for(i in 0 until r)
    {
        for(j in 0 until c)
        {
            if(arr[i][j]==time)
            {
                charr[i][j]='.'
                for(k in 0 until 4)
                {
                    val nextx=i+dx[k]
                    val nexty=j+dy[k]
                    if(nextx in 0 until r && nexty in 0 until c)
                        charr[nextx][nexty]='.'
                }
            }
        }
    }
}
private fun setbomb(time:Int,r:Int,c:Int)
{
    for(i in 0 until r)
    {
        for(j in 0 until c)
        {
            if(charr[i][j]=='.')
            {
                charr[i][j]='O'
                arr[i][j]=time+3
            }
        }
    }
}