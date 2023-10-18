package 자바.leetcode.LeetCode80;

class Solution {
    /* 80. Remove Duplicates from Sorted Array II*/
    public static int removeDuplicates(int[] nums) {
        int answer = 1;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (count < 1)
                    nums[answer++] = nums[i];
                count++;
            } else {
                count = 0;
                nums[answer++] = nums[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3})); // 5
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3})); // 7
    }
}