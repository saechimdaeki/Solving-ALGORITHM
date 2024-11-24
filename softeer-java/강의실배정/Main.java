package 강의실_배정;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Class> classes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            classes.add(new Class(start, end));
        }

        classes.sort(Comparator.comparingInt(o -> o.end));
        int answer = 1;
        int now = classes.get(0).end;
        for (int i = 1; i < classes.size(); i++) {
            if (now <= classes.get(i).start) {
                now = classes.get(i).end;
                answer++;
            }
        }
        System.out.println(answer);

    }

    static class Class {
        int start;
        int end;

        public Class(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
