package 프로그래머스.자물쇠와열쇠.kotlin으로풀기

class Solution {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val n=lock.size
        val m=key.size
        var tmpkey=key
        val newlock=Array(n*3){Array(n*3){0}}
        for(i in 0 until n)
        {
            for(j in 0 until n)
                newlock[i+n][j+n]=lock[i][j]
        }
        for(rotation in 0 until 4)
        {
            tmpkey=rotate(key)
            for(x in 0 until n*2)
            {
                for(y in 0 until n*2)
                {
                    for(i in 0 until m)
                        for(j in 0 until m)
                            newlock[x+i][y+j]+=tmpkey[i][j]
                    if(check(newlock)) return true
                    for(i in 0 until m)
                    {
                        for(j in 0 until m)
                            newlock[x+i][y+j]-=tmpkey[i][j]
                    }
                }
            }
        }
        return false
    }
    fun rotate(arr:Array<IntArray>):Array<IntArray>{
        val n=arr.size
        val m =arr[0].size
        val result=Array(n){ IntArray(m){0} }
        for(i in 0 until n)
        {
            for(j in 0 until m)
                result[j][n-i-1]=arr[i][j]
        }
        return result
    }
    fun check(newlock:Array<Array<Int>>):Boolean{
        val lockleng=newlock.size/3
        for(i in lockleng until lockleng*2)
        {
            for(j in lockleng until lockleng*2)
                if(newlock[i][j]!=1)
                    return false
        }
        return true
    }
}

fun main() {
    val s= Solution()
    println("${s.solution(arrayOf(intArrayOf(0,0,0), intArrayOf(1,0,0), intArrayOf(0,1,1)), arrayOf(
            intArrayOf(1,1,1), intArrayOf(1,1,0), intArrayOf(1,0,1)
    ))}")
}