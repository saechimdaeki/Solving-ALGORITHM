fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val arr=Array(13){0}
    arr[1]=1
    arr[2]=2
    arr[3]=4
    arr[4]=7
    for(i in 5 until 12)
    arr[i]=arr[i-1]+arr[i-2]+arr[i-3]
    for(i in 0 until n)
    bw.write("${arr[br.readLine().toInt()]}\n")
    bw.flush()
}