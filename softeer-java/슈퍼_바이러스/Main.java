package 자바.softeer.슈퍼_바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    static int divide = 1000000007;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] kpn = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long k = kpn[0];
        long p = kpn[1];
        long n = kpn[2] * 10;

        System.out.println((solve(n, p) * k) % divide);

    }

    static long solve(long count, long p) {
        if (count == 1) return p;
        long result = solve(count / 2, p);

        result = result * result % divide;
        if (count % 2 == 1)
            result = (result * p) % divide;
        return result;
    }
}