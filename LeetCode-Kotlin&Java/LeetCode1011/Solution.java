package LeetCode1011;

import java.util.Arrays;

/* 1011. Capacity To Ship Packages Within D Days */
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left=1,right= Arrays.stream(weights).sum();
        while (left<=right){
            int mid=(left+right)/2;
            if(possible(mid,weights,D))
                right=mid-1;
            else
                left=mid+1;
        }
        return left;
    }
    private boolean possible(int mid,int[] weights, int d){
        int day=0,sum=0;
        for (int weight : weights) {
            if (mid < weight) return false; //예외
            sum += weight;
            if (sum > mid) { // 날이 지남.
                sum = weight;
                day += 1;
            }
        }
        if(sum>0) day++; //마지막
        return day <= d; //if ~ else
    }
}
