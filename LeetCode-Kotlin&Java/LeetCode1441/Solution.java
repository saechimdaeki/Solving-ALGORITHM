package LeetCode1441;

import java.util.*;

/* 1441. Build an Array With Stack Operations */
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list=new ArrayList<>();
        int cnt=0;
        for(int i=1; cnt!=target.length && i<=n; i++){
            if(target[cnt]== i){
                list.add("Push");
                cnt++;
            }else{
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }
}