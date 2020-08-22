fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var t=br.readLine().toInt()
    while (t-- >0)
    {
        val n=br.readLine().toInt()
        val trie=Trie13504()
        var jupmisa=0
        val list= arrayListOf<Int>()
        trie.add(0)
        val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
        for( i in arr.indices)
        {
            jupmisa=jupmisa xor arr[i]
            trie.add(jupmisa)
            val tmp= trie.search(jupmisa) xor jupmisa
            list.add(tmp)
        }
        bw.write("${list.max()}\n")
    }
    bw.flush()
}
private class Trie13504{
    inner class Node{
        val child=IntArray(2){-1}
        var valid=false
    }
    val list= arrayListOf<Node>()
    var root=0
    fun init():Int{
        val x= Node()
        list.add(x)
        return list.size-1
    }
    init {
        root=init()
    }
    fun add(node:Int, num:Int, bit:Int){
        if(bit==-1)
        {
            list[node].valid=true
            return
        }
        val c= num shr bit and 1
        if(list[node].child[c]==-1)
            list[node].child[c]=init()
        add(list[node].child[c],num,bit-1)
    }
    fun add(n:Int){
        add(root,n,31)
    }
    fun search(node:Int,n:Int,bit:Int):Int{
        if(bit==-1)
            return 0
        var c=(n shr bit) and 1
        c=1-c
        if(list[node].child[c]==-1)
            c=1-c
        if(list[node].child[c]==-1)
            return 0
        var next=0
        if(c==1)
            next= 1 shl bit
        return next or search(list[node].child[c],n, bit-1)
    }
    fun search(n:Int):Int{
        return search(root,n,31)
    }

}