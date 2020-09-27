package 백준
private lateinit var arr:Array<IntArray>
private lateinit var command:IntArray
private val dx= intArrayOf(0,0,-1,1)
private val dy= intArrayOf(1,-1,0,0)
private val dice=IntArray(6)
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var (n,m,x,y,k)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n){ IntArray(m) }
    for(i in 0 until n){
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices){
            arr[i][j]=input[j]
        }
    }
    command=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    for(i in command.indices){
        val (nx,ny)= arrayOf(x+dx[command[i]-1],y+dy[command[i]-1])
        if(nx<0 || nx>=n || ny<0 || ny>=m) continue
            roll(command[i])
            if(arr[nx][ny]==0)
                arr[nx][ny]=dice[3]
            else{
                dice[3]=arr[nx][ny]
                arr[nx][ny]=0
            }
            x=nx
            y=ny
            bw.write("${dice[1]}\n")
    }
    bw.flush()
}
private fun roll(x:Int){
    val tmparr=IntArray(6)
    when (x) {
        1 -> {
            tmparr[0]= dice[0]
            tmparr[1]=dice[4]
            tmparr[2]= dice[2]
            tmparr[3]= dice[5]
            tmparr[4]= dice[3]
            tmparr[5]= dice[1]
        }
        2 -> {
            tmparr[0]= dice[0]
            tmparr[1]= dice[5]
            tmparr[2]= dice[2]
            tmparr[3]= dice[4]
            tmparr[4]= dice[1]
            tmparr[5]= dice[3]
        }
        3 -> {
            tmparr[0]= dice[1]
            tmparr[1]= dice[2]
            tmparr[2]= dice[3]
            tmparr[3]= dice[0]
            tmparr[4]= dice[4]
            tmparr[5]= dice[5]
        }
        4 -> {
            tmparr[0]= dice[3]
            tmparr[1]= dice[0]
            tmparr[2]= dice[1]
            tmparr[3]= dice[2]
            tmparr[4]= dice[4]
            tmparr[5]= dice[5]
        }
    }
    for(i in tmparr.indices){
        dice[i]=tmparr[i]
    }
}
