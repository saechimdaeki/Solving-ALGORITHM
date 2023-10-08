package 자바.softeer.강의실_배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(start, end));
        }

        lectures.sort(Comparator.comparingInt(Lecture::getEnd));
        int nowTime = 0;
        int ans = 0;
        for (Lecture lecture : lectures) {
            if (lecture.start >= nowTime) {
                ans++;
                nowTime = lecture.end;
            }
        }
        System.out.println(ans);
    }
}

class Lecture {
    int start;
    int end;

    public int getEnd() {
        return end;
    }

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}