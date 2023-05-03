package 연속된_부분수열의합;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int sum = sequence[0];
        while (right < sequence.length && left <= right) {
            if (sum == k) {
                if (len > right - left + 1) {
                    len = right - left +1;
                    answer[0] = left;
                    answer[1] = right;
                }

                if (left == right) break;

                sum -= sequence[left];

                if (right +1 < sequence.length)
                    sum += sequence[right+1];
                left++;
                right++;
            } else if (sum > k){
                sum -= sequence[left++];
            } else {
                if (right +1 < sequence.length)
                    sum += sequence[right+1];
                right++;
            }
        }

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        for (int output : solution.solution(new int[]{1, 2, 3, 4, 5}, 7)) {
            System.out.print(output);
        } // 2, 3
        System.out.println();

        for (int output : solution.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5)) {
            System.out.print(output);
        } // 6, 6
        System.out.println();

        for (int output : solution.solution(new int[]{2, 2, 2, 2, 2}, 6)) {
            System.out.print(output);
        } // 0, 2

    }
}