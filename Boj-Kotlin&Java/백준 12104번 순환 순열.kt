fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val a=br.readLine()
    val b=br.readLine()
    var tmp=b+b
    tmp=tmp.substring(0,tmp.length-1)
    //println(tmp)
    val answer=kmp(tmp,a)
    println(answer.size)
}
private fun preprocessing(p:String):IntArray{
    val pi=IntArray(p.length){0}
    var j=0
    for(i in 1 until p.length)
    {
        while(j>0 && p[i]!=p[j])
            j=pi[j-1]
        if(p[i]==p[j])
        {
            pi[i]=j+1
            j++
        }else
            pi[i]=0
    }
    return pi
}

private fun kmp(s:String,p:String):ArrayList<Int>{
    val pi=preprocessing(p)
    var j=0
    val answer= arrayListOf<Int>()
    for(i in s.indices)
    {
        while(j>0 &&s[i]!=p[j])
            j=pi[j-1]
        if(s[i]==p[j])
        {
            if(j==p.length-1) {
                answer.add(i - p.length + 1)
                //println("${i-p.length+1}")
                j = pi[j]
            }else
                j++
        }
    }
    return answer
}