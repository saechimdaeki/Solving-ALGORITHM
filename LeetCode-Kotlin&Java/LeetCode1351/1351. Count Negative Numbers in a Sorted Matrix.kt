package LeetCode1351

class Solution {
    fun countNegatives(grid: Array<IntArray>): Int {
        var cnt=0
        grid.forEach { ints ->
            repeat(ints
                .filter { it <0 }.size
            ) { cnt++ }
        }
        return cnt
    }
}
