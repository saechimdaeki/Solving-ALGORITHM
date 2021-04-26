package LeetCode986;

import java.util.ArrayList;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstIdx=0,secondIdx=0;
        ArrayList<int[]> list=new ArrayList<>();
        while (firstIdx< firstList.length && secondIdx<secondList.length){
            int firstStart=firstList[firstIdx][0];
            int firstEnd=firstList[firstIdx][1];
            int secondStart=secondList[secondIdx][0];
            int secondEnd=secondList[secondIdx][1];

            if(firstEnd<secondStart) firstIdx++;
            else if(firstStart>secondEnd) secondIdx++;
            else if (firstList[firstIdx][1] <= secondList[secondIdx][1]) {
                list.add(new int[]{Math.max(firstList[firstIdx][0], secondList[secondIdx][0]), firstList[firstIdx][1]});
                firstIdx++;
            } else {
                list.add(new int[]{Math.max(firstList[firstIdx][0], secondList[secondIdx][0]), secondList[secondIdx][1]});
                secondIdx++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
