private lateinit var arr:Array<Array<Char>>
private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (r,c)=br.readLine().split(" ")
            .map { it.toInt()}
    arr=Array(r){Array(c){' '}}
    for(i in 0 until r)
    {
        val input=br.readLine()
        for(j in input.indices)
        {
            arr[i][j]=input[j]
        }
    }
    var sheepSafe=true
    mainFor@for(i in 0 until r)
    {
        for(j in 0 until c)
        {
            if(arr[i][j]=='S')
            {
                for(k in 0 until 4)
                {
                    var x=i+dx[k]
                    var y=j+dy[k]
                    if(x in 0 until r && y in 0 until c)
                    {
                        if(arr[x][y]=='W') {
                            sheepSafe = false
                            break@mainFor
                        }
                    }
                }

            }
        }
    }
    if(!sheepSafe)
    println(0)
    else
    {
        println(1)
        for(i in 0 until r)
        {
            for(j in 0 until c)
            {
                if(arr[i][j]=='.')
                    bw.write("D")
                else
                    bw.write("${arr[i][j]}")
            }
            bw.write("\n")
        }
    }
    bw.flush()



}