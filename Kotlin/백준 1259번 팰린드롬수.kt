
fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    while(true)
    {
        val s= br.readLine()
        if(s=="0")
            break
        val tmp=s.reversed()
        if(s==tmp)
            bw.write("yes\n")
        else
            bw.write("no\n")

    }
    bw.flush()
}
/*
private fun manchers(s:String):IntArray{
    var s1="." + join(".", s.split("")) + ".";
    var n=s.length
    var radius=IntArray(n){0}
    var ridx=0
    var cidx=0
    for(i in 0 until n)
    {
        if(i<=ridx)
            radius[i]= min(radius[2*cidx-i],ridx-i)
        while(0<= i-radius[i]-1 && i+radius[i]+1<n
                && s1[i-radius[i]-1]==s1[i+radius[i]+1])
            radius[i]++
        if(ridx<i+radius[i]){
            ridx=i+radius[i]
            cidx=i
        }
    }
    return radius
}

 */