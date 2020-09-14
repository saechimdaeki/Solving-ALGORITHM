package 백준

import java.util.*
import kotlin.math.max


private lateinit var map: Array<IntArray>
private var maxCnt = 0

private fun move(dir: Int,n:Int) {
    val q=LinkedList<Int>()
    when (dir) {
        0 -> {
            for(i in 0 until n){
                for(j in 0 until n){
                    if(map[j][i]!=0)
                        q.offer(map[j][i])
                    map[j][i]=0
                }
                var idx=0
                while (q.isNotEmpty()){
                    val now=q.poll()
                    when {
                        map[idx][i]==0 -> map[idx][i]=now
                        map[idx][i]==now -> {
                            map[idx][i]*=2
                            idx++
                        }
                        else -> {
                            idx++
                            map[idx][i]=now
                        }
                    }
                }
            }
        }
        1->{
            for(i in 0 until n){
                for(j in n-1 downTo 0){
                    if(map[j][i]!=0)
                        q.offer(map[j][i])
                    map[j][i]=0
                }
                var idx=n-1
                while (q.isNotEmpty()){
                    val now=q.poll()
                    when {
                        map[idx][i]==0 -> map[idx][i]=now
                        map[idx][i]==now -> {
                            map[idx][i]*=2
                            idx--
                        }
                        else -> {
                            idx--
                            map[idx][i]=now
                        }
                    }
                }
            }
        }
        2->{
            for(i in 0 until n){
                for(j in 0 until n){
                    if(map[i][j]!=0)
                        q.offer(map[i][j])
                    map[i][j]=0
                }
                var idx=0
                while (q.isNotEmpty()){
                    val now=q.poll()
                    when {
                        map[i][idx]==0 -> map[i][idx]=now
                        map[i][idx]==now -> {
                            map[i][idx]*=2
                            idx++
                        }
                        else -> {
                            idx++
                            map[i][idx]=now
                        }
                    }
                }
            }
        }
        3 -> {
            for(i in 0 until n){
                for(j in n-1 downTo 0){
                    if(map[i][j]!=0)
                        q.offer(map[i][j])
                    map[i][j]=0
                }
                var idx=n-1
                while (q.isNotEmpty()){
                    val now=q.poll()
                    when {
                        map[i][idx]==0 -> map[i][idx]=now
                        map[i][idx]==now -> {
                            map[i][idx]*=2
                            idx--
                        }
                        else -> {
                            idx--
                            map[i][idx]=now
                        }
                    }
                }
            }
        }
    }
}

private fun dfs(cnt: Int,n:Int) {
        if (cnt == 5) {
            for (i in 0 until n)
            maxCnt= max(maxCnt,map[i].max()!!)
            return
        }
        val copymap = Array(n) { IntArray(n) }
        for(i in 0 until n){
            for(j in 0 until n)
                copymap[i][j]= map[i][j]
        }
        for (i in 0 until 4) {
            move(i,n)
            dfs(cnt + 1,n)
            for(j in 0 until n){
                for(k in 0 until n)
                    map[j][k]=copymap[j][k]
            }
        }
/*
        println("===============================")
        for(i in 0 until n) {
            for (j in 0 until n) {
                print("${map[i][j]} ")
            }
            println()
        }
        println("===============================")
*/
}
fun main() {
    val br =System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n = br.readLine().toInt()
    map = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        val input=br.readLine().split(" ").map { it.toInt() }
        for (j in input.indices) {
            map[i][j] = input[j]
            }
        }
    dfs(0,n)
    bw.write("$maxCnt")
    bw.flush()
}
