package boj14681kot

private lateinit var arr:Array<Array<Int>>
fun main(args:Array<String>)
{
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
    var countarray=Array(3){0}
    solve(countarray,0,0,n)
    for(i in countarray)
        println(i)

}
private fun solve(countarray:Array<Int>,x:Int,y:Int,n:Int)
{
    if(same(x,y,n))
    {
        countarray[arr[x][y]+1]++
        return
    }
    var m=n/3
    for(i in 0 until 3)
    {
        for(j in 0 until 3)
            solve(countarray,x+i*m,y+j*m,m)
    }
}
private fun same(x:Int, y:Int,n:Int):Boolean{
    for(i in x until x+n)
    {
        for(j in y until y+n)
        {
            if(arr[x][y]!=arr[i][j])
                return false
        }
    }
    return true
}