fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val arr=br.readLine().split(" ").map{it.toInt()}
    val count=LongArray(m)
    count[0]=1
    var sum=0
    for(i in 0 until n){
        sum+=arr[i]
        sum%=m
        count[sum]++
    }
    var answer:Long=0
    for(i in 0 until m)
        answer+= count[i]*(count[i]-1)/2
    println(answer)
}