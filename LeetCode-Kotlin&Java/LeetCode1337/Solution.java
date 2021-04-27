package LeetCode1337;

import java.util.ArrayList;
import java.util.Comparator;

/* 1337. The K Weakest Rows in a Matrix */
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        ArrayList<pair> list=new ArrayList<>();
        int[] answer=new int[k];
        for(int i=0; i< mat.length; i++){
            int cnt=0;
            for(int j=0; j<mat[i].length; j++) if (mat[i][j] == 1) cnt++;
            list.add(new pair(i,cnt));
        }
        list.sort(Comparator.comparingInt(o -> o.sol));
        int index=0;
        for (pair pair : list) {
            if(index<k) answer[index]=pair.row;
            index++;
        }
        return answer;
    }
}

class pair {
    int row;
    int sol;

    public pair(int row, int sol) {
        this.row = row;
        this.sol = sol;
    }
}
