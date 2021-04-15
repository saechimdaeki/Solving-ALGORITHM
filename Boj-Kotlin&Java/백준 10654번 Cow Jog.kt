import java.util.*

fun main() {
    val br=System.`in`.bufferedReader()
    val (in1 ,in2)=br.readLine().split(" ")
    val n=in1.toInt()
    val t=in2.toLong()
    val arr=LongArray(n+1)
    for(i in 0 until n){
        val (a,b)=br.readLine().split(" ").map { it.toLong() }
        arr[i]=a+t*b
    }
    val st= Stack<Long>()
    st.push(arr[0])
    (1 until n).forEach { i ->
        while (st.size>0 && arr[i]<=st.peek()) st.pop()
        st.push(arr[i])
    }
    print("${st.size}")
}