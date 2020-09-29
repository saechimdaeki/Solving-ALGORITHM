package 백준
private val arr=IntArray(10000001){it}
fun main() {
    val bw=System.out.bufferedWriter()
    for(i in 2..10000000){
        if(arr[i]==0) continue
        for(j in (i+i)..10000000 step i){
            arr[j]=0
        }
    }
    val list= arrayListOf<Int>()
    for(i in 2..10000000){
        if(arr[i]!=0)
            list.add(i)
    }
    println(list[readLine()!!.toInt()-1])
   // bw.write("${list[readLine()!!.toInt()-1]}")
   // bw.flush()
}