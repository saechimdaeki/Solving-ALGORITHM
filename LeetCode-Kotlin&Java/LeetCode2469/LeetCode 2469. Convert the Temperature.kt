package LeetCode2469

import java.text.DecimalFormat

class Solution {
    fun convertTemperature(celsius: Double): DoubleArray {
        val df = DecimalFormat("#.#####")
        return doubleArrayOf(df.format(celsius + 273.15).toDouble(), df.format((celsius * 1.80) + 32.00).toDouble())
    }
}