fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val array=Array(n){0L}
    for(i in 0 until n)
    {
        array[i]=br.readLine().toLong()
    }

    array.sort()

    var answer=array[0]
    var answer_cnt=1
    var cnt=1
    for(i in 1 until n)
    {
        if(array[i]==array[i-1])
            cnt++
        else
            cnt=1
        if(answer_cnt<cnt)
        {
            answer_cnt=cnt
            answer=array[i]
        }
    }
    println(answer)
}