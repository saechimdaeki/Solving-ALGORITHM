package softeer.gpt식_숫자_비교;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(scanner.nextLine());
        }

        Collections.sort(list, new GPTComparator());

        for (String s : list) {
            System.out.println(s);
        }

    }

}

class GPTComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        String[] aParts = a.split("\\.");
        String[] bParts = b.split("\\.");

        int x1 = Integer.parseInt(aParts[0]);
        int x2 = Integer.parseInt(bParts[0]);

        if (x1 != x2) {
            return Integer.compare(x1, x2);
        }

        // 소수 부분 비교 (소수점 뒤 부분)
        int y1 = (aParts.length > 1) ? Integer.parseInt(aParts[1]) : -1;
        int y2 = (bParts.length > 1) ? Integer.parseInt(bParts[1]) : -1;

        return Integer.compare(y1, y2);
    }
}
