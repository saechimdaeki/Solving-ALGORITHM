package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val map=HashMap<Char,Int>()
    while (true) {
        val s = br.readLine() ?: break
        for(i in s.indices){
            if(s[i]==' ') continue
            if(map.containsKey(s[i]))
                map[s[i]]=map[s[i]]!!+1
            else
                map[s[i]]=1
        }
    }
    val list= arrayListOf<Pair<Char,Int>>()
    for(i in map.keys){
        list.add(Pair(i,map[i]!!))
    }
    list.sortByDescending { it.second }
    val tmp=list[0].second
    val list2= arrayListOf<Char>()
    for(i in list) {
        if(tmp>i.second)
            break
        list2.add(i.first)
    }
    list2.sort()
    for(i in list2)
        print("$i")
}