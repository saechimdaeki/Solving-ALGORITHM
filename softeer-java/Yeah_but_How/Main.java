package Yeah_but_How;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        for (int i = 0; i< s.length()-1; i++) {
            System.out.print(s.charAt(i));
            if (s.charAt(i) == '(' && s.charAt(i+1) == ')') {
                System.out.print("1");
            }
            if (s.charAt(i)==')' && s.charAt(i+1)=='(') {
                System.out.print("+");
            }
        }
        System.out.print(s.charAt(s.length()-1));
    }
}
