package boj14681kot

private var answer=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val list=ArrayList<String>()
    val visited=ArrayList<Boolean>()
    for(i in 0 until n){
        list.add(br.readLine())
        visited.add(false)
    }
    for(i in list.indices)
    {
        if(visited[i])
            continue
        var tmp=list[i]
        visited[i]=true
        for(j in tmp.indices)
        {
            tmp += tmp[0]
            tmp=tmp.substring(1,tmp.length)
           // println(tmp)
            for(k in i+1 until list.size)
            {
                if(tmp==list[k])
                    visited[k]=true
            }
        }
        answer++
    }
    println(answer)
}
