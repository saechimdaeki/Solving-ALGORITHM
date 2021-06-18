class Solution {
    fun oddCells(m: Int, n: Int, indices: Array<IntArray>): Int {
        val arr = Array(m) { IntArray(n) }
        var oddCount = 0
        indices.indices.forEach { i ->
            val row = indices[i][0]
            val col = indices[i][1]
            (0 until n).forEach { j ->
                if (arr[row][j] % 2 == 1) {
                    oddCount -= 1
                }
                arr[row][j] += 1
                when {
                    arr[row][j] % 2 == 1 -> {
                        oddCount += 1
                    }
                }
            }
            (0 until m).forEach { j ->
                when {
                    arr[j][col] % 2 == 1 -> {
                        oddCount -= 1
                    }
                }
                arr[j][col] += 1
                when {
                    arr[j][col] % 2 == 1 -> {
                        oddCount += 1
                    }
                }
            }
        }
        return oddCount
    }
}