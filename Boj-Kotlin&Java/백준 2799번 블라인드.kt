package boj14681kot

private val arr=Array(5){0}
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (m,n)=br.readLine().split(" ").map { it->it.toInt() }
    val charr=Array(5*m+1){Array(5*n+1){' '}}
    for(i in 0 until 5*m+1)
    {
        val input=br.readLine()
        for(j in input.indices)
        {
            charr[i][j]=input[j]
        }
    }
    for(i in 1 until 5*m+1 step 5)
    {
        for(j in 1 until 5*n+1 step 5)
        {
            if(charr[i][j]=='.')
                arr[0]++
            else if(charr[i+1][j]=='.')
                arr[1]++
            else if(charr[i+2][j]=='.')
                arr[2]++
            else if(charr[i+3][j]=='.')
                arr[3]++
            else
                arr[4]++
        }
    }
    for(i in arr)
        print("$i ")
}