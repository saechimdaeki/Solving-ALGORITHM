import kotlin.math.max


fun main(args: Array<String>) {
    val s=System.`in`.bufferedReader().readLine()
    var tmp=""
    var answer=-1
    for(i in s.indices)
    {
        tmp=s.substring(i)
        val nextprocess=preprocessing(tmp)
        for(i in nextprocess.indices)
            answer= max(answer,nextprocess[i])
    }
    println(answer)
}
private fun preprocessing(s:String):IntArray{
    val pi=IntArray(s.length){0}
    var j=0
    for(i in 1 until s.length)
    {
        while (j>0 && s[i]!=s[j])
            j=pi[j-1]
        if(s[i]==s[j])
        {
            pi[i]=j+1
            j++
        }else
            pi[i]=0
    }
    return pi
}