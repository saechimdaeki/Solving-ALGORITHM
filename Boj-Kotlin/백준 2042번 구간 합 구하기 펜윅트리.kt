private lateinit var arr:LongArray
private lateinit var tree:LongArray
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var (n,m,k)=br.readLine().split(" ").map {it.toInt()}
    arr= LongArray(n+1)
    tree=LongArray(n+1)
    for(i in 1..n){
        arr[i]=br.readLine().toLong()
        update(i,arr[i])
    }
    m+=k
    while (m-->0){
        var (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        if(a==1){
            var diff=c-arr[b]
            arr[b]=c.toLong()
            update(b,diff)
        }else{
            bw.write("${sum(c)- sum(b-1)}\n")
        }
    }
    bw.flush()
}
private fun update(i:Int,diff:Long){
    var i2=i
    while (i2<tree.size){
        tree[i2]+=diff
        i2+= (i2 and -i2)
    }
}
private fun sum(i:Int):Long{
    var i2=i
    var answer:Long=0
    while (i2>0){
        answer+=tree[i2]
        i2-= (i2 and -i2)
    }
    return answer
}