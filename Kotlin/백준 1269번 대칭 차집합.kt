fun main() {
    val br=System.`in`.bufferedReader()
    val (asize,bsize)=br.readLine().split(" ").map { it.toInt() }
    val a=br.readLine().split(" ").map { it.toInt() }.toSortedSet()
    val b=br.readLine().split(" ").map { it.toInt() }.toSortedSet()
    var (acnt,bcnt)= intArrayOf(a.size,bsize)
    for(i in b)
    {
        if(a.contains(i))
            acnt--
    }
    for(i in a)
    {
        if(b.contains(i))
            bcnt--
    }
    println(acnt+bcnt)


}