
private lateinit var arr:Array<ArrayList<Int>>
private lateinit var child:Array<ArrayList<Int>>
private val tin=IntArray(100001){-1}
private val tout=IntArray(100001){-1}
private val low=IntArray(100001){-1}
private val depth=IntArray(100001){-1}
private var cnt=0
fun main() {
    val br=System.`in`.bufferedReader();
    val bw=System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }

    arr=Array(n+1){ArrayList<Int>()}
    child=Array(n+1){ArrayList<Int>()}

    repeat(m){
        val (f,t)=br.readLine().split(" ").map { it.toInt() }
        arr[f].add(t)
        arr[t].add(f)
    }
    dfs(1,0,0)
    val t=br.readLine().toInt()
    repeat(t){
        val input=br.readLine().split(" ").map { it.toInt() }.toIntArray()
        when {
            input[0]==1 -> {
                var (a,b,c,d)= arrayOf(input[1],input[2],input[3],input[4])
                when {
                    upper(c,d) -> {
                        var tmp=c
                        c=d
                        d=tmp
                    }
                }
                when {
                    low[c]<tin[c] -> bw.write("yes\n")
                    upper(c,a)==upper(c,b) -> bw.write("yes\n")
                    else -> bw.write("no\n")
                }
            }
            else -> {
                var (a,b,c)= arrayOf(input[1],input[2],input[3])
                when {
                    !upper(c,a)&&!upper(c,b) -> bw.write("yes\n")
                    upper(c,a) && upper(c,b) -> {
                        val e=findChild(c,a)
                        val f=findChild(c,b)
                        when {
                            e==f -> bw.write("yes\n")
                            low[e]<tin[c]&&low[f]<tin[c] -> bw.write("yes\n")
                            else -> bw.write("no\n")
                        }
                    }
                    else -> {
                        when {
                            upper(c,a) -> {
                                var tmp=a
                                a=b
                                b=tmp
                            }
                        }
                        val e=findChild(c,b)
                        when {
                            low[e]<tin[c] -> bw.write("yes\n")
                            else -> bw.write("no\n")
                        }
                    }
                }
            }
        }
    }
    bw.flush()
}
private fun dfs( u:Int,  parent:Int, dept:Int){
    tin[u]=cnt
    low[u]=cnt
    cnt++
    depth[u]=dept
    loop@ for(v in arr[u]){
        when (v) {
            parent -> continue@loop
        }
        when {
            tin[v]==-1 -> {
                dfs(v,u,dept+1)
                low[u]= minOf(low[u],low[v])
                child[u].add(v)
            }
            else -> low[u]= minOf(low[u],tin[v])
        }
    }
    tout[u]=cnt++
}

private fun upper(a:Int,b:Int):Boolean{
    return tin[a]<=tin[b] && tout[b]<=tout[a]
}

private fun findChild(v:Int,des:Int):Int{
    var (left,right)= arrayOf(0,child[v].size-1)
    while (left!=right){
        val mid=(left+right)/2
        when {
            tin[des]>tout[child[v][mid]] -> left=mid+1
            tout[des]<tin[child[v][mid]] -> right=mid-1
            else -> {
                left=mid
                right=mid
            }
        }

    }
    return child[v][left]
}