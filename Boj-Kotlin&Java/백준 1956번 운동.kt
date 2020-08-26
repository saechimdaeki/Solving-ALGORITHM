fun main() {
    val br=System.`in`.bufferedReader()
    val (v,e)=br.readLine().split(" ").map { it.toInt() }
    val arr=Array(v){Array(v){0}}
    repeat(e){
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        if(arr[a-1][b-1]==0)
            arr[a-1][b-1]=c
        else if(arr[a-1][b-1]>c)
            arr[a-1][b-1]=c
    }
    for(k in 0 until v)
    {
        for(i in 0 until v)
        {
            for(j in 0 until v)
            {
                if(arr[i][k]!=0 && arr[k][j]!=0)
                {
                    if(arr[i][j]==0 || arr[i][j]>arr[i][k]+arr[k][j])
                        arr[i][j]=arr[i][k]+arr[k][j]
                }
            }
        }
    }
    var answer=-1
    for(i in 0 until v)
    {
        if(arr[i][i]!=0)
        {
            if(answer==-1 || answer>arr[i][i])
                answer=arr[i][i]
        }
    }
    println(answer)
}