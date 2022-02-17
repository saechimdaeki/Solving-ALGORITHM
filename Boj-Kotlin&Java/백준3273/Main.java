package 백준3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 백준 3273번 두 수의 합*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> sooYul = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed()
                .sorted().collect(Collectors.toList());

        int x= Integer.parseInt(br.readLine());
        int answer=0;
        int left=0,right=n-1;
        if (left < right) {
            do {
                int sum = sooYul.get(left) + sooYul.get(right);
                if (sum == x) answer++;
                if (sum < x) left++;
                else
                    right--;
            } while (left < right);
        }
        System.out.println(answer);
    }
}
