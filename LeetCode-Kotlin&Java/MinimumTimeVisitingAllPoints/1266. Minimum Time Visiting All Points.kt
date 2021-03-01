package MinimumTimeVisitingAllPoints

import kotlin.math.abs

class Solution {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var ans=0
        for (i in 0 until points.size-1) {
            val x= abs(points[i][0]-points[i+1][0])
            val y= abs(points[i][1]-points[i+1][1])
            val d= abs(x-y)
            val c= abs(maxOf(x,y)-d)
            ans+=(d+c)
        }
        return ans
    }
}