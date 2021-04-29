package LeetCode1018;

import java.util.ArrayList;
import java.util.List;

/* 1018. Binary Prefix Divisible By 5 */
class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        ArrayList<Boolean> list=new ArrayList<>();
        int idx=0;
        for (int j : A) {
            list.add((idx = (idx * 2 + j) % 5) == 0);
        }
        return list;
    }
}
