fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val l=br.readLine().toInt()
    val ad=br.readLine()
    val lst=processing(ad)
    println(l-lst[l-1])
}
private fun processing(s:String):IntArray{
    val pi=IntArray(s.length)
    var j=0
    for(i in 1 until s.length)
    {
        while (j>0 && s[i]!=s[j])
            j=pi[j-1]
        if(s[i]==s[j])
        {
            pi[i]=j+1
            j++
        }else pi[i]=0

    }
    return pi
}