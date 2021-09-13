package LeetCode658;


import java.util.ArrayList;
import java.util.List;
/* 658. Find K Closest Elements*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> answer=new ArrayList<>();
        int left=0, right=arr.length-1;
        while(right-left>=k){
            int leftDist=Math.abs(arr[left]-x);
            int rightDist=Math.abs(arr[right]-x);

            if(leftDist<=rightDist)
                right--;
            else
                left++;
        }
        while(left<=right){
            answer.add(arr[left++]);
        }
        return answer;
    }
}
