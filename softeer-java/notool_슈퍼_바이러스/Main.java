package softeer.notool_슈퍼_바이러스;

import java.io.*;
import java.util.*;

public class Main {
    static int divide = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        long p = sc.nextLong();
        long n = sc.nextLong();

        n *= 10;

        long ans = virus(n, p);
        System.out.println(ans * k % divide);
    }

    static long virus(long n, long p) {
        if (n == 1)
            return p;
        long half = virus(n / 2, p);
        if (n % 2 == 0)
            return half * half % divide;
        else
            return (half * half % divide) * p % divide;
    }
}
