private lateinit var parent:Array<Int>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    parent=Array(n+1){0}
    for(i in 1..n)
        parent[i]=i
    for(i in 0 until m)
    {
        val (a,b,c)=br.readLine().split(" ")
                .map { it.toInt() }
        if(a==0)
        {
            union(b,c)
        }else{
            if(find(b)==find(c))
            {
                bw.write("YES\n")
            }else
                bw.write("NO\n")
        }
    }
    bw.flush()
}
private fun find(x:Int):Int{
  if(x==parent[x])
      return x
    parent[x]=find(parent[x])
    return parent[x]
}

private fun union(x:Int,y:Int)
{
    val (parentx,parenty) = intArrayOf(find(x),find(y))
    parent[parenty]=parentx
}