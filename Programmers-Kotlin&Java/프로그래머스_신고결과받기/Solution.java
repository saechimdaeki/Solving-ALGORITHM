package 프로그래머스_신고결과받기;

import java.util.*;

public class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, List<String>> alarmMap=new HashMap<>();
        Map<String,Integer> stopMap= new HashMap<>();
        for (String s : report) {
            String[] s1 = s.split(" ");
            String reporter= s1[0], receiver=s1[1];
            if(alarmMap.containsKey(reporter)){
                if(!alarmMap.get(reporter).contains(receiver)) {
                    List<String> strings = alarmMap.get(reporter);
                    strings.add(receiver);
                    alarmMap.put(reporter, strings);
                    stopMap.put(receiver, stopMap.getOrDefault(receiver,0)+1);
                }
            }else{
                List<String> receivers=new ArrayList<>();
                receivers.add(receiver);
                alarmMap.put(reporter, receivers);
                stopMap.put(receiver, stopMap.getOrDefault(receiver,0)+1);
            }
        }
        Set<String> reportSet=new HashSet<>();
        for (Map.Entry<String, Integer> entry : stopMap.entrySet()) {
            Integer value = entry.getValue();
            if(value>=k){
                reportSet.add(entry.getKey());
            }
        }
        int[] answer=new int[id_list.length];

        for (int i=0; i< id_list.length; i++) {
            int cnt;
            List<String> strings = alarmMap.containsKey( id_list[i]) ? alarmMap.get(id_list[i]) : new ArrayList<>();
            cnt = (int) reportSet.stream().filter(strings::contains).count();
            answer[i]=cnt;
        }
        return answer;
    }
}

class Main{
    public static void main(String[] args) {
        int[] solution = Solution.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
        for (int i : solution) {
            System.out.print(i+",");
        } // 2, 1, 1, 0,
        int[] solution1 = Solution.solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
        for (int i : solution1) {
            System.out.print(i+",");
        } // 0,0
    }
}
