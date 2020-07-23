fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var (n,m)=br.readLine().split(" ").map { it.toInt() }
    val trie=trie()
    while(n-- >0)
        trie.add(br.readLine())
    var answer=0
    while (m-->0)
    {
        if(trie.search(br.readLine()))
            answer++
    }
    bw.write("$answer")
    bw.flush()
}
private class trie{
    internal class node{
        val child = IntArray(26) { -1 }
        var valid = false
    }
    var list=ArrayList<node>()
    var root=0
    fun init():Int{
        var x=node()
        list.add(x)
        return list.size-1
    }
    constructor(){
        list= ArrayList<node>()
        root=init()
    }
    fun add(node:Int,s:String,idx:Int){
        if(idx==s.length){
            list[node].valid=true
            return
        }
        var c=s[idx]-'a'
        if(list[node].child[c]==-1)
        {
            var next=init()
            list[node].child[c]=next
        }
        val child=list[node].child[c]
        add(child,s,idx+1)
    }
    fun add(s:String){
        add(root,s,0)
    }
    fun search(node:Int,s:String,idx:Int):Boolean{
        if(node==-1)
            return false
        if(idx==s.length)
            return list[node].valid
        val c=s[idx]-'a'
        val child=list[node].child[c]
        return search(child,s,idx+1)
    }
    fun search(s:String):Boolean{
        return search(root,s,0)
    }
}