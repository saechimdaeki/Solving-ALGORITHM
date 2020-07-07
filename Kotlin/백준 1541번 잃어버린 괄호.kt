package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    var string=br.readLine()
    var tmp=""
    string+="e"
    var minus=false
    var answer=0
    for(i in string.indices)
    {
        if(string[i]=='+'||string[i]=='-'||string[i]=='e')
        {
            if(minus)
                answer-=(tmp.toInt())
            else
                answer+=(tmp.toInt())
            tmp=""
            if(string[i]=='-')
                minus=true
            continue
        }

        tmp+=string[i]
    }
    println(answer)
}