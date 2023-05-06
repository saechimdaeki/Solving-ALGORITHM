package 자바.과제진행하기;

import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        List<HomeWork> homeWorkList = new ArrayList<>();
        Arrays.stream(plans).forEach(plan -> {
            String[] hourAndMin = plan[1].split(":");
            homeWorkList.add(new HomeWork(plan[0], Integer.parseInt(hourAndMin[0]) * 60 + Integer.parseInt(hourAndMin[1]), Integer.parseInt(plan[2])));
        });
        homeWorkList.sort(Comparator.comparingInt(o -> o.startTime));

        ArrayDeque<HomeWork> todo = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < homeWorkList.size() -1 ; i++) {
            int now = homeWorkList.get(i).startTime + homeWorkList.get(i).time;
            int nextTime = homeWorkList.get(i+1).startTime;

            if (now <= nextTime) {
              answer[idx++] = homeWorkList.get(i).name;

              int remainTime = nextTime - now;
              while (remainTime > 0 && !todo.isEmpty()) {
                  HomeWork homeWork = todo.peek();
                  if (homeWork.time > remainTime) {
                      homeWork.time -= remainTime;
                      remainTime = 0;
                  } else {
                      remainTime -= homeWork.time;
                      answer[idx++] = homeWork.name;
                      todo.poll();
                  }
              }
            } else {
                homeWorkList.get(i).time = now - nextTime;
                todo.push(homeWorkList.get(i));
            }
        }

        answer[idx++] = homeWorkList.get(homeWorkList.size() - 1).name;

        while (!todo.isEmpty()) {
            answer[idx++] = todo.poll().name;
        }
        return answer;
    }
}

class HomeWork {
    String name;
    int startTime;
    int time;

    public HomeWork(String name, int startTime, int time) {
        this.name = name;
        this.startTime = startTime;
        this.time = time;
    }
}

class Main {
    public static void main(String[] args) {
//        String[] solution = new Solution().solution(new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}});
//        System.out.println(Arrays.toString(solution)); // korean english math

        String[] solution1 = new Solution().solution(new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});
        System.out.println(Arrays.toString(solution1)); // science history computer music
    }
}
