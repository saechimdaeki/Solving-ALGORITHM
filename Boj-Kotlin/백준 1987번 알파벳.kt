package boj14681kot

private lateinit var charr:Array<String>
private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)

private fun solve(board:Array<String>,check:BooleanArray,x:Int,y:Int):Int{
    var answer=0
    for(i in 0..3)
    {
        val nx=x+dx[i]
        val ny=y+dy[i]
        if(nx>=0 && nx<board.size && ny>=0 && ny<board[0].length)
        {
            if(!check[board[nx][ny]-'A'])
            {
                check[board[nx][ny]-'A']=true
                val next= solve(board,check,nx,ny)
                if(answer<next)
                    answer=next
                check[board[nx][ny]-'A']=false
            }

        }
    }
    return answer+1
}
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (r,c)=br.readLine().split(" ").map { it->it.toInt() }

    charr=Array(r){""}
    for(i in 0 until r)
    {
        val input=br.readLine()
        charr[i]=input
    }

    val checked=BooleanArray(26)
    checked[charr[0][0]-'A']=true
    println(solve(charr,checked,0,0))
}
