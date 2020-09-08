package 백준

import kotlin.system.exitProcess

private lateinit var arr:Array<IntArray>
private val teacher= arrayListOf<Pair<Int,Int>>()
private val student= arrayListOf<Pair<Int,Int>>()
private val point= arrayListOf<Pair<Int,Int>>()
private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
fun main() {
    val n= readLine()!!.toInt()
    arr= Array(n){ IntArray(n) } //없음:0 학생 1 선생님2 장애물 3으로처리
    for(i in 0 until n){
        val input= readLine()!!.split(" ")
        for(j in input.indices){
            when {
                input[j]=="X" -> {
                    arr[i][j] = 0
                    point.add(Pair(i,j))
                }
                input[j]=="S" -> {
                    arr[i][j] = 1
                    student.add(Pair(i,j))
                }
                input[j]=="T" -> {
                    arr[i][j] = 2
                    teacher.add(Pair(i,j))
                }
            }
        }
    }
    dfs(0,0,n)
    println("NO")
}
private fun istrue(t: Pair<Int,Int>,n:Int):Boolean{
    for(i in 0 until 4){
        var x=t.first
        var y=t.second
        while (x+dx[i] in 0 until n && y+dy[i] in 0 until n){
            x+=dx[i]
            y+=dy[i]
            if(arr[x][y]==3)
                break
            else if(arr[x][y]==1)
                return true
        }
    }
    return false
}
private fun dfs(idx:Int,cnt:Int,n:Int){
    if(idx==3){
        for(t in teacher){
            if(istrue(t,n))
                return
        }
        println("YES")
        exitProcess(0)
    }
    for(i in cnt until point.size){
        arr[point[i].first][point[i].second]=3
        dfs(idx+1,i+1,n)
        arr[point[i].first][point[i].second]=0
    }
}