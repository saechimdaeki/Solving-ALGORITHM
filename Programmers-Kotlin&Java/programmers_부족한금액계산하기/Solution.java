package programmers_부족한금액계산하기;

class Solution {
    public static long solution(int price, int money, int count) {
        long sum=price*((long) count *(count+1)/2);
        return Math.max((sum - money), 0);
    }
}
