package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    while (true){
        val (r,n)=br.readLine().split(" ").map { it.toInt() }
        if(r==-1 && n==-1)
            break
        val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
        var answer=0
        var index=0
        arr.sort()
        while (index<n){
           val left=arr[index++]
            while (index<n && arr[index]<=left+r)
                index++
            val right=arr[index-1]
            while (index<n && arr[index]<=right+r)
                index++
            answer++
        }
        bw.write("$answer\n")
    }
    bw.flush()
}