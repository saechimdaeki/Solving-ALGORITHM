package boj14681kot

import kotlin.math.max

private val dx= arrayOf(0,0,1,-1)
private val dy= arrayOf(1,-1,0,0)
private lateinit var arr:Array<IntArray>
private lateinit var check:Array<BooleanArray>
private var answer=0
private var n =0
private var m= 0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val firsttinput=br.readLine().split(" ")
    n=firsttinput[0].toInt()
    m=firsttinput[1].toInt()
    arr=Array(n){IntArray(m){0} }
    check=Array(n){BooleanArray(m){false} }
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ")
        for(j in 0 until m)
            arr[i][j]=input[j].toInt()
    }
    for(i in 0 until n)
    {
        for( j in 0 until m)
        {
            bruteforce(i,j,0,0)
            if(j+2<m)
            {
                val tmp=arr[i][j]+arr[i][j+1]+arr[i][j+2]
                if(i-1>=0)
                {
                    val tmp2=tmp+arr[i-1][j+1]
                    answer=max(answer,tmp2)
                }
                if(i+1<n){
                    val tmp2=tmp+arr[i+1][j+1]
                    answer=max(answer,tmp2)
                }
            }
            if(i+2<n){
                val tmp=arr[i][j]+arr[i+1][j]+arr[i+2][j]
                if(j+1<m){
                    val tmp2=tmp+arr[i+1][j+1]
                    answer= max(answer,tmp2)
                }
                if(j-1>=0)
                {
                    val tmp2=tmp+arr[i+1][j-1]
                    answer=max(answer,tmp2)
                }
            }
        }
    }
    println(answer)
}
fun bruteforce(x:Int, y:Int , sum:Int, cnt:Int){
    if(cnt==4){
        answer= max(answer,sum)
        return
    }
    if(x<0 || x>=n || y<0 || y>=m)
        return
    if(check[x][y])
        return
    check[x][y]=true
    for(i in 0 until 4 step 1)
        bruteforce(x+dx[i], y+dy[i],sum+arr[x][y],cnt+1)
    check[x][y]=false

}