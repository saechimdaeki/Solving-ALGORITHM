private var b=0
private var answer=-1
fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val input=br.readLine().split(" ")
    var a=input[0].toCharArray()
    b=input[1].toInt()
    a.sort()
    do{
        var c=stoi(a)
        if(a[0]!='0' && c<b){
            if(answer==-1 || answer<c)
                answer=c
        }
    }while (next(a))
    println(answer)
}
private fun stoi(c:CharArray):Int
{
    var answer=0
    for(i in c)
        answer=answer*10+(i-'0')
    return answer
}
private fun next(c:CharArray):Boolean{
    var i =c.size-1
    while(i>0 && c[i-1]>=c[i])
        i--
    if(i<=0)
        return false
    var j=c.size-1
    while(c[j]<=c[i-1])
        j--
    var tmp=c[i-1]
    c[i-1]=c[j]
    c[j]=tmp
    j=c.size-1
    while(i<j)
    {
        tmp=c[i]
        c[i]=c[j]
        c[j]=tmp
        i++
        j--
    }
    return true


}

