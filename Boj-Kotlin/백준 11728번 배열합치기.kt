package boj14681kot

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    var tmp=br.readLine().split(" ").map { it.toInt() }
    val arr1=Array(n){0}
    for(i in tmp.indices)
        arr1[i]=tmp[i]
    val arr2=Array(m){0}
    var tmp2=br.readLine().split(" ").map { it.toInt() }
    for(i in tmp2.indices)
        arr2[i]=tmp2[i]
    var answer=Array(n+m){0}
    var i=0
    var j=0
    var k=0
    while(i<n ||j<m){
        if(j>=m ||(i<n && arr1[i]<=arr2[j]))
            answer[k++]=arr1[i++]
        else
            answer[k++]=arr2[j++]
    }
    for(i in 0 until n+m)
        bw.write("${answer[i]} ")
    bw.flush()
}