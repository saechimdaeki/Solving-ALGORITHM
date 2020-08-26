package 백준

import java.util.*

private lateinit var arr:LongArray
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr= LongArray(n)
    for(i in arr.indices)
        arr[i]=br.readLine().toLong()
    var answer:Long=0
    val st=Stack<Pair<Long,Long>>()
    for(i in arr.indices){
        var number:Long=1
        while (st.isNotEmpty() && st.peek().first<=arr[i]){
            if(st.peek().first==arr[i]){
                answer+=st.peek().second
                number=st.peek().second+1
                st.pop()
            }else{
                answer+=st.peek().second
                st.pop()
                number=1
            }
        }
        if(st.isNotEmpty())
            answer++
        st.push(Pair(arr[i],number))
    }
    println(answer)
}