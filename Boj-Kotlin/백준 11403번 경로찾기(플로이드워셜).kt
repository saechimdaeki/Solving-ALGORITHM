private lateinit var arr:Array<Array<Int>>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    arr=Array(n){Array(n){0}}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    for(k in 0 until n)
    {
        for(i in 0 until n)
        {
            for(j in 0 until n)
            {
                if(arr[i][k]==1 && arr[k][j]==1)
                    arr[i][j]=1
            }
        }
    }
    for(i in 0 until n)
    {
        for(j in 0 until n)
            bw.write("${arr[i][j]} ")
        bw.write("\n")
    }
    bw.flush()

}