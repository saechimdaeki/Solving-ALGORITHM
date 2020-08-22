fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine()
    val p=br.readLine()
    val list=kmp(t,p)
    bw.write("${list.size}\n")
    list.forEach { bw.write("${it+1} ") }
    bw.flush()
}
private fun preprocessing(p:String):IntArray{
    var m=p.length
    val pi=IntArray(m){0}
    var j=0
    for(i in 1 until m)
    {
        while (j>0 && p[i]!=p[j])
            j=pi[j-1]
        if(p[i]==p[j]) {
            pi[i] =j+1
            j++
        }else pi[i]=0
    }
    return pi
}
private fun kmp(s:String , p:String):ArrayList<Int>{
    val pi=preprocessing(p)
    val answerlist=ArrayList<Int>()
    var j=0
    for(i in s.indices)
    {
        while (j>0 && s[i]!=p[j])
            j=pi[j-1]

        if(s[i]==p[j]){
            if(j==p.length-1)
            {
                answerlist.add(i-p.length+1)
                j=pi[j]
            }else
                j++
        }
    }
    return answerlist
}