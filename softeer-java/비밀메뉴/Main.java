package 비밀메뉴;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        String secret = IntStream.range(0, m).mapToObj(i -> String.valueOf(sc.nextInt())).collect(Collectors.joining());
        String customer = IntStream.range(0, n).mapToObj(i -> String.valueOf(sc.nextInt())).collect(Collectors.joining());
        System.out.println(customer.contains(secret) ? "secret" : "normal");
    }
}
