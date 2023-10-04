package 자바.softeer.변속기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isAscending = false, isDescending = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                isAscending = true;
                if (isDescending) break;
            } else if (arr [i] < arr[i-1]) {
                isDescending = true;
                if (isAscending) break;
            }
        }
        if (isAscending && isDescending)
            System.out.println("mixed");
        else if (isAscending)
            System.out.println("ascending");
        else
            System.out.println("descending");
    }
}