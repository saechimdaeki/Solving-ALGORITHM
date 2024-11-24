package 효도_음식;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        int leftCurrentMax = arr[0];
        leftSum[0] = leftCurrentMax;
        for (int i = 1; i < n; i++) {
            leftCurrentMax = Math.max(leftCurrentMax + arr[i], arr[i]);
            leftSum[i] = Math.max(leftSum[i-1], leftCurrentMax);
        }

        int rightCurrentMax = arr[n-1];
        rightSum[n-1] = rightCurrentMax;
        for (int i = n-2; i >= 0; i--) {
            rightCurrentMax = Math.max(rightCurrentMax + arr[i], arr[i]);
            rightSum[i] = Math.max(rightSum[i+1], rightCurrentMax);
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n - 2; i++) {
            answer = Math.max(answer, leftSum[i] + rightSum[i + 2]);
        }

        System.out.println(answer);
    }
}
