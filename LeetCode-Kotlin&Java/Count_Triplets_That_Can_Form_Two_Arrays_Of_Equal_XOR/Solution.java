package 자바.leetcode.Count_Triplets_That_Can_Form_Two_Arrays_Of_Equal_XOR;


class Solution {

    public static int countTriplets(int[] arr) {
        int answer = 0;
        for (int i =0; i< arr.length; i ++) {
            int now = arr[i] ;
            for (int k = i+1; k< arr.length; k++) {
                now ^= arr[k];
                if (now == 0) {
                    answer += k - i;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{2,3,1,6,7})); // 4
        System.out.println(countTriplets(new int[]{1,1,1,1,1})); // 10
    }
}