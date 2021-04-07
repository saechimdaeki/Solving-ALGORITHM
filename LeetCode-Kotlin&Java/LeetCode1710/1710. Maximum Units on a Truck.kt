package LeetCode1710





class Solution {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        boxTypes.sortWith(Comparator{a,b ->b[1]-a[1]})
        var cnt=0
        var truck=truckSize
        for (i in boxTypes.indices) {
            if(truck<=0) break
            cnt+= minOf(truck,boxTypes[i][0])*boxTypes[i][1]
            truck-=boxTypes[i][0]
        }
        return cnt
    }
}