package NumberOfRectanglesThatCanFormTheLargestSquare

class Solution {
    fun countGoodRectangles(rectangles: Array<IntArray>): Int {
        var (maxlen,maxcnt)= arrayOf(0,0)
        for(i in rectangles.indices){
            val now= minOf(rectangles[i][0],rectangles[i][1])
            when {
                now>maxlen -> {
                    maxlen=now
                    maxcnt=1
                }
                now==maxlen -> maxcnt++
            }
        }
        return maxcnt
    }
}