import java.util.*
import kotlin.collections.ArrayList

private lateinit var num:IntArray
private lateinit var check:BooleanArray
fun main() {
    val sc = Scanner(System.`in`)
    val bw=System.out.bufferedWriter()
    val t=sc.nextInt()
    repeat(t){
        val n=sc.nextInt()
        val m=sc.nextInt()
        val k=sc.nextInt()
        val a= Array(2*(n+m)){ ArrayList<Int>()}
        val ar=Array(2*(n+m)){ArrayList<Int>()}

        num= IntArray(2*(n+m))
        check= BooleanArray(2*(n+m))
        (0 until k).forEach { i ->
            var p=sc.nextInt()
            var q=sc.nextInt()
            var r=sc.nextInt()
            var s=sc.nextInt()
            q+=n
            s+=n
            if(p==r && q==s) return@forEach
            val (p_,q_,r_,s_) = intArrayOf(p,q,r,s)
            when {
                p_>r_ -> {
                    q=-q
                    s=-s
                }
            }
            when {
                q_>s_ -> {
                    p=-p
                    r=-r
                }
            }
            when {
                p==r -> {
                    edge(a,ar,p,r,n+m)
                }
                q==s -> edge(a,ar,q,s,n+m)
                else -> {
                    edge(a,ar,p,r,n+m)
                    edge(a,ar,s,r,n+m)
                    edge(a,ar,p,q,n+m)
                    edge(a,ar,s,q,n+m)
                }
            }
        }
        val s= arrayListOf<Int>()
        check.fill(false)
        for(i in 0 until 2*(n+m))
            dfs(a,i,s)
        check.fill(false)
        num.fill(0)
        var cnt=0
        (2*(n+m)-1 downTo 0)
            .asSequence()
            .filterNot { check[s[it]] }
            .forEach { dfs(ar,s[it],cnt++) }
        val checking= (0 until n+m).none { num[it]==num[2*(n+m)- it -1] }
        bw.write(if(checking) "Yes\n" else "No\n")
    }
    bw.flush()
}
private fun dfs(a:Array<ArrayList<Int>>, x:Int, s:ArrayList<Int> ){
    when {
        check[x] -> return
        else -> {
            check[x] = true
            a[x].forEach { i ->
                dfs(a, i, s)
            }
            s.add(x)
        }
    }
}

private fun dfs(a:Array<ArrayList<Int>>, x:Int, cnt:Int){
    when {
        check[x] -> return
        else -> {
            check[x] = true
            num[x] = cnt
            a[x].forEach { i ->
                dfs(a, i, cnt)
            }
        }
    }
}
private fun node(x:Int, y:Int):Int{
    return when {
        x>0 -> x-1
        else -> 2 * y + x
    }
}
private fun edge(a:Array<ArrayList<Int>>, ar:Array<ArrayList<Int>>, from:Int, to:Int, m:Int){
    a[node(-from,m)].add(node(to,m))
    ar[node(to,m)].add(node(-from,m))
    a[node(-to,m)].add(node(from,m))
    ar[node(from,m)].add(node(-to,m))
}
