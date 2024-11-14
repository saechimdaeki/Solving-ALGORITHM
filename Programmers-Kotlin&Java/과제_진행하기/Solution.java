package 과제진행하기;

import java.util.*;

class Solution {
    public static String[] solution(String[][] plansArr) {
        Homework[] homework = Arrays.stream(plansArr).map(Homework::new).toArray(Homework[]::new);
        Arrays.sort(homework, Comparator.comparingInt(a -> a.start));
        Stack<Homework> stop = new Stack<>();
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < homework.length - 1; i++) {
            Homework curHomework = homework[i];
            Homework nextHomework = homework[i + 1];

            if(curHomework.getEndTime() > nextHomework.start) {
                curHomework.spendTime = curHomework.getEndTime() - nextHomework.start;
                stop.push(curHomework);
                continue;
            }
            answer.add(curHomework.name);

            int restTime = nextHomework.start - curHomework.getEndTime();
            while(restTime > 0 && !stop.isEmpty()) {
                Homework stoppedHomework = stop.peek();
                int timeDiff = stoppedHomework.spendTime - restTime;
                stoppedHomework.spendTime = timeDiff;
                restTime = timeDiff * -1;
                if(timeDiff > 0) break;
                answer.add(stop.pop().name);
            }
        }

        answer.add(homework[homework.length - 1].name);
        while(!stop.isEmpty()) answer.add(stop.pop().name);
        return answer.toArray(new String[0]);
    }
    static class Homework {
        String name;
        int start;
        int spendTime;

        public Homework(String name, String start, String spendTime) {
            this.name = name;
            String[] time = start.split(":");
            this.start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]); // 시간 * 60 + 분
            this.spendTime = Integer.parseInt(spendTime);
        }

        public Homework(String[] plan) {
            this(plan[0], plan[1], plan[2]);
        }

        public int getEndTime() {
            return start + spendTime;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[][]{{"korean", "11:40", "30"},
                {"english", "12:10", "20"},
                {"math", "12:30", "40"}}))); // ["korean", "english", "math"]
        System.out.println(Arrays.toString(solution(new String[][]{{"science", "12:40", "50"},
                {"music", "12:20", "40"},
                {"history", "14:00", "30"},
                {"computer", "12:30", "100"}}))); //["science", "history", "computer", "music"]
        System.out.println(Arrays.toString(solution(new String[][]{{"aaa", "12:00", "20"}, {"ccc", "12:40", "10"}}))); // ["bbb", "ccc", "aaa"]
    }

}