package ProgrammersWeeklyChallange8;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public static int solution(int[][] sizes) {
        AtomicInteger m1= new AtomicInteger();
        AtomicInteger m2= new AtomicInteger();
        Arrays.stream(sizes).forEach(
                s-> {
                    m1.set(Math.max(m1.get(), Arrays.stream(s).max().orElse(0)));
                    m2.set(Math.max(m2.get(), Arrays.stream(s).min().orElse(0)));
                }
        );
        return m1.get() * m2.get();
    }

    public static void main(String[] args) {
        System.out.println("solution(new int[][]{{60,50},{30,70},{60,30},{80,40}}) = " + solution(new int[][]{{60,50},{30,70},{60,30},{80,40}}));
    }
}
