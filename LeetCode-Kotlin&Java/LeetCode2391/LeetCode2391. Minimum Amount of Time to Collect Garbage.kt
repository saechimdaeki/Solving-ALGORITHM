package 코틀린.LeetCode.LeetCode2391

class Solution {
    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
        var answer = 0

        for(i in 1 until travel.size)
            travel[i] = travel[i-1] + travel[i]
        val garbageMap = mutableMapOf<Char, Int>()

        garbage.indices.forEach { i ->
            garbage[i].forEach { garbage1 ->
                garbageMap[garbage1] = i
            }
            answer += garbage[i].length
        }
        val type = "MPG"
        type.forEach { c ->
            answer += if (garbageMap.getOrDefault(c, 0) == 0) 0 else travel[garbageMap[c]!! - 1]
        }
        return answer
    }
}