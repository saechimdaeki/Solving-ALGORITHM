package 코틀린.숫자카드나누기

class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var answer = 0

        var a = arrayA.first()
        var b = arrayB.first()

        (1 until arrayA.size).forEach { i ->
            a = gcd(a, arrayA[i])
            b = gcd(b, arrayB[i])
        }

        when {
            notDivided(arrayB,a) && answer < a -> answer = a
        }

        when {
            notDivided(arrayA,b) && answer < b -> answer = b
        }

        return answer
    }

    fun gcd(a: Int, b: Int): Int {
        if (a % b == 0) return b
        return gcd(b, a % b)
    }

    fun notDivided(arr: IntArray, num: Int) : Boolean {
        return arr.indices.none { arr[it]%num ==0 }
    }
}

fun main() {
    Solution().apply {
        println(solution(intArrayOf(10, 17), intArrayOf(5, 20))) // 0
        println(solution(intArrayOf(10, 20), intArrayOf(5, 17))) // 10
        println(solution(intArrayOf(14, 35, 119), intArrayOf(18, 30, 102))) // 7

    }
}