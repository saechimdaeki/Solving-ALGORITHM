fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var t=br.readLine().toInt()
    while (t-- > 0)
    {
        val n=br.readLine().toInt()
        val stringarray= Array(n){""}
        val list=Trie5052()
        for(i in 0 until n)
        {
            stringarray[i]=br.readLine()
            list.add(list.root,stringarray[i],0)
        }
        if(list.check(list.root))
            bw.write("YES\n")
        else
            bw.write("NO\n")
    }
    bw.flush()
}
private class Trie5052{
    inner class Node{
        val child=IntArray(10){-1}
        var valid=false
    }
    var list= arrayListOf<Node>()
    var root=0
    fun init():Int{
        val x=Node()
        list.add(x)
        return list.size-1
    }
    init {
        root=init()
    }
    fun add(node:Int,s:String,idx:Int){
        if(idx==s.length) {
            list[node].valid = true
            return
        }
        var c=s[idx]-'0'
        if(list[node].child[c]==-1)
        {
            val next=init()
            list[node].child[c]=next
        }
        add(list[node].child[c],s,idx+1)
    }
    fun check(node:Int):Boolean{
        for(i in 0 until 10)
        {
            if(list[node].child[i]!=-1)
            {
                if(list[node].valid)
                    return false
                else
                {
                    if(!check(list[node].child[i]))
                        return false
                }
            }
        }
        return true
    }
}