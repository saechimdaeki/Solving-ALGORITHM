package LeetCode1769

class Solution {
    fun minOperations(boxes: String): IntArray {
        val temp= arrayListOf<Int>()

        boxes.indices
                .asSequence()
                .filter { boxes[it]=='1' }
                .forEach { temp.add(it) }

        val answer= arrayListOf<Int>()
        boxes.indices.forEach { idx ->
            val cnt= temp.sumBy {
                when {
                    it >idx -> it -idx
                    else -> idx- it
                }
            }
            answer.add(cnt)
        }
        return answer.toIntArray()
    }
}

fun main() {
    val s=Solution()
    val answer1=s.minOperations("110")
    answer1.forEach { i ->
        print("$i ")
    }
    println()
    val answer2=s.minOperations("001011")
    answer2.forEach { i ->
        print("$i ")
    }
}