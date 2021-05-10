package LeetCode_2021May_CountPrimes;


import java.util.stream.IntStream;

class Solution {
    public int countPrimes(int n) {
        int answer;
        boolean[] visited=new boolean[n];
        IntStream.range(2, n).forEach(i -> visited[i] = true);
        IntStream.iterate(2, i -> i * i < n, i -> i + 1)
                .filter(i -> visited[i])
                .flatMap(i -> IntStream.iterate(i * i, j -> j < n, j -> j + i))
                .forEachOrdered(j -> visited[j] = false);
        answer = (int) IntStream.range(2, n).filter(i -> visited[i]).count();
        return answer;
    }
}

