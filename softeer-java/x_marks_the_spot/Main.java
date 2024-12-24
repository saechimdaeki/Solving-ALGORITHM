package softeer.x_marks_the_spot;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String s = sc.next();
            String t = sc.next();

            int index = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'x' || c == 'X') {
                    index = i;
                    break;
                }
            }

            sb.append(Character.toUpperCase(t.charAt(index)));

        }

        System.out.println(sb);
    }
}
