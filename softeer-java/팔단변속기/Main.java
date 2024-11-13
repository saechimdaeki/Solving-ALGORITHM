package 팔단변속기;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[8];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        boolean flag = arr[0] == 1;

        for (int i = 0; i < arr.length-1; i++) {
            if ((arr[i] <= arr[i+1] && !flag) || (arr[i] > arr[i+1] && flag)) {
                System.out.println("mixed");
                return;
            }
        }

        if (flag)
            System.out.println("ascending");
        else
            System.out.println("descending");
    }
}
