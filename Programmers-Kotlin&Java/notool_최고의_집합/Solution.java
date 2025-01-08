package programmers.notool_최고의_집합;

class Solution {
    public int[] solution(int n, int s) {        
        if (n > s)
            return new int[]{-1};
        
        int[] answer = new int[n];
        int baseValue = s / n;
        int remainder = s % n;        
        for (int i = 0; i < n; i++) {
            if (i < n - remainder) {
                answer[i] = baseValue;
            } else {
                answer[i] = baseValue + 1;
            }
        }
        
        return answer;
    }
}