package 루돌프_월드컵;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] f = new int[4];
        for (int i = 0; i < 4; i++) {
            f[i] = scanner.nextInt();
        }

        double result = calculateProbability(f);

        System.out.printf("%.3f%n", result);
    }

    private static double calculateProbability(int[] f) {
        List<double[]> allCombinations = new ArrayList<>();

        double totalProbability = 0.0;

        double[] scores = new double[5];
        Arrays.fill(scores, 0.0);

        simulateMatches(f, scores, 0, 1.0, allCombinations);

        for (double[] score : allCombinations) {
            int rank = getRank(score);
            if (rank <= 2) {
                totalProbability += score[4];
            }
        }

        return totalProbability * 100;
    }

    private static void simulateMatches(int[] f, double[] scores, int matchIndex, double currentProbability, List<double[]> results) {
        int[][] matches = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3}};

        if (matchIndex == matches.length) {
            double[] result = scores.clone();
            result[4] = currentProbability;
            results.add(result);
            return;
        }

        int i = matches[matchIndex][0];
        int j = matches[matchIndex][1];

        double totalPower = 5.0 * (f[i] + f[j]);
        double winProbabilityI = (4.0 * f[i]) / totalPower;
        double winProbabilityJ = (4.0 * f[j]) / totalPower;
        double drawProbability = (f[i] + f[j]) / totalPower;

        scores[i] += 3;
        simulateMatches(f, scores, matchIndex + 1, currentProbability * winProbabilityI, results);
        scores[i] -= 3;

        scores[j] += 3;
        simulateMatches(f, scores, matchIndex + 1, currentProbability * winProbabilityJ, results);
        scores[j] -= 3;

        scores[i] += 1;
        scores[j] += 1;
        simulateMatches(f, scores, matchIndex + 1, currentProbability * drawProbability, results);
        scores[i] -= 1;
        scores[j] -= 1;
    }

    private static int getRank(double[] scores) {
        double score1 = scores[0];

        int rank = 1;
        for (int i = 1; i < 4; i++) {
            if (scores[i] > score1) {
                rank++;
            }
        }
        return rank;
    }
}
