/* 유파식 풀이 */
private val parent=Array(101){0}
fun main() {
    val br=System.`in`.bufferedReader()
    val comnum=br.readLine().toInt()
    val gansunnum=br.readLine().toInt()

    for(i in 1..comnum)
        parent[i]=i
    for(i in 0 until gansunnum)
    {
        var (from ,to)=br.readLine().split(" ")
                .map { it.toInt() }
        if(from<to)
        {
            var tmp=from
            from=to
            to=tmp
        }
        union(from,to)
    }
    var answer=0
    for(i in 2..comnum)
    {
        if(find(1)==find(i))
            answer++
    }
    println(answer)
}

private fun find(x:Int):Int{
    if(x==parent[x])
        return x
    parent[x]=find(parent[x])
    return parent[x]
}
private fun union(x:Int,y:Int){
    val (parentx,parenty)= intArrayOf(find(x),find(y))
    if(parentx!=parenty)
        parent[parenty]=parentx
}