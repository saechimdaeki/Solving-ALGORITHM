package LeetCode868;

import java.util.ArrayList;
import java.util.Collections;

/* 868. Binary Gap */
class Solution {
    public int binaryGap(int n) {
        String s= Integer.toBinaryString(n);
        ArrayList<Integer> list=new ArrayList<>();
        int now=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                list.add(i-now);
                now=i;
            }
        }
        return Collections.max(list);
    }
}