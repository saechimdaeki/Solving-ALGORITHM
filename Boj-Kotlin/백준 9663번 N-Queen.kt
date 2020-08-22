package boj14681kot

private var answer=0
private var n=0
private val chess=Array(16){Array(16){false}}
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    n=br.readLine().toInt()
    solve(0)
    println(answer)
}
private fun solve(row:Int){
    if(row==n)
        answer++
    for(col in 0 until n)
    {
        chess[row][col]=true
        if(check(row,col))
            solve(row+1)
        chess[row][col]=false
    }
}
private fun check(row:Int,col:Int):Boolean{
    for(i in 0 until n)
    {
        if(i==row)
            continue
        if(chess[i][col])
            return false
    }
    /* \ */
    var x=row-1
    var y=col-1
    while(x>=0 && y>=0)
    {
        if(chess[x][y])
            return false
        x--
        y--
    }
    x=row-1
    y=col+1
    /* / */
    while(x>=0 && y<n)
    {
        if(chess[x][y])
            return false
        x--
        y++
    }
    return true
}