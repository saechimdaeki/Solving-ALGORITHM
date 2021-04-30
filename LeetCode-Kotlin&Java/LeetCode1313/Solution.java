package LeetCode1313;

import java.util.ArrayList;

class Solution {
    public int[] decompressRLElist(int[] nums) {
        int[] freq=new int[nums.length/2];
        int[] value=new int[nums.length/2];
        int fidx=0,vidx=0;
        ArrayList<Integer> list=new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if(i%2==0) freq[fidx++] = nums[i];
            else value[vidx++] = nums[i];
        }
        for (int i=0; i<freq.length; i++) {
            int times=freq[i];
            while (times-->0) list.add(value[i]);
        }
        return list.stream().mapToInt(integer -> integer).toArray();
    }
}
