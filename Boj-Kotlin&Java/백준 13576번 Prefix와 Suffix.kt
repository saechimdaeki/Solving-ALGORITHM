private val arraylist1= arrayListOf<Int>()
private val arraylist2= arrayListOf<Int>()
private lateinit var cnt:IntArray
fun main(args: Array<String>) {
    val s=System.`in`.bufferedReader().readLine()
    val bw=System.out.bufferedWriter()
    val n=s.length
    cnt= IntArray(n+1)
    val pi=preprocessing(s)
    for(i in 0 until n)
        cnt[pi[i]]++
    for(i in n downTo 1)
        cnt[pi[i-1]]+=cnt[i]
    run {
        var i=n
        while (i>0){
            arraylist1.add(i)
            arraylist2.add(cnt[i]+1)
            i=pi[i-1]
        }
    }
    bw.write("${arraylist1.size}\n")
    for(i in arraylist1.size-1 downTo 0)
        bw.write("${arraylist1[i]} ${arraylist2[i]}\n")
    bw.flush()
}
private fun preprocessing(p:String):IntArray{
    val pi=IntArray(p.length)
    var j=0
    for(i in 1 until p.length)
    {
        while (j>0 && p[i]!=p[j])
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