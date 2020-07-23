fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it.toInt() }
    val trie=trie13505()
    val list= arrayListOf<Int>()
    for(i in 0 until n)
    {
        trie.add(arr[i])
        list.add(trie.search(arr[i]) xor arr[i])
    }
    println(list.max()!!)
}
private class trie13505{
    inner class node{
        val child=IntArray(2){-1}
        var valid=false
    }
    var list=ArrayList<node>()
    var root=0
    fun init():Int{
        val x=node()
        list.add(x)
        return list.size-1
    }
    init {
        root=init()
    }
    fun add(node:Int,num:Int,bit:Int){
        if(bit==-1)
        {
            list[node].valid=true
            return
        }
        var c= (num shr bit) and 1
        if(list[node].child[c]==-1)
            list[node].child[c]=init()
        add(list[node].child[c],num,bit-1)
    }
    fun add(num:Int){
        add(root,num,31)
    }
    fun search(node:Int,num:Int,bit:Int):Int{
        var c= (num shr bit) and 1
        c=1-c
        if(list[node].child[c]==-1)
            c=1-c
        if(list[node].child[c]==-1)
            return 0
        var next=0
        if(c==1)
            next= 1 shl bit
        return next or search(list[node].child[c],num,bit-1)
    }
    fun search(num:Int):Int{
        return search(root,num,31)
    }

}