package 릿코드.twosum;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0; i< nums.length; i++){
            int tmp=target- nums[i];
            if(map.containsKey(tmp))
                return new int[]{map.get(tmp),i};
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] answer1=s.twoSum(new int[]{2,7,11,15},9);
        int[] answer2=s.twoSum(new int[]{3,2,4},6);
        int[] answer3=s.twoSum(new int[]{3,3},6);
        System.out.println("==answer1=====");
        for(int i : answer1)
            System.out.print(i+" ");
        System.out.println();
        System.out.println("==answer2=====");
        for( int i:answer2)
            System.out.print(i+" ");
        System.out.println();
        System.out.println("==answer3=====");
        for(int i:answer3)
            System.out.print(i+" ");
    }
}
