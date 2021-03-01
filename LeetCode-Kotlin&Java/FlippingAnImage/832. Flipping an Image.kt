package FlippingAnImage

import java.util.*

class Solution {
    fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
        val answer = Array(image.size) { intArrayOf() }
        image.indices.forEach { i ->
            val s = Stack<Int>()
            image[i].forEach { j ->
                s.push(j)
            }
            val arr = arrayListOf<Int>()
            while (s.isNotEmpty()) {
                arr.add(s.pop())
            }
            answer[i] = arr.toIntArray()
        }

        answer.indices.forEach { i ->
            answer[i].indices.forEach { j ->
                answer[i][j] = (answer[i][j] + 1) % 2
            }
        }
        return answer
    }
}
