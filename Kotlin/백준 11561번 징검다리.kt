fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    repeat(t){
        val input=br.readLine().toLong()
        var left=1L
        var right=input
        var mid=0L
        while (left<=right)
        {
             mid=(left+right)/2
            if(mid*(mid+1) > 2*input)
                right=mid-1
            else
                left=mid+1
        }
        if(mid*(mid+1) > 2*input)
            mid--
        bw.write("${mid}\n")
    }
    bw.flush()
}