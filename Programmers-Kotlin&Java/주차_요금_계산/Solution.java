package 자바.프로그래머스.주차_요금_계산;

import java.util.*;

class Solution {
    public static int[] solution(int[] fees, String[] records) {

        int defaultTime = fees[0];
        int defaultMoney = fees[1];
        int addtionalTime = fees[2];
        int addtionalMoney = fees[3];
        Map<String, Map<String,String>> carRecordMap = new HashMap<>();
        List<String> carNumberList = new ArrayList<>();
        Map<String, Integer> cardMoneyMap = new HashMap<>();
        Map<String, String> noOutCar = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();
        int dayEnd = 23 * 60 + 59;
        for (String record : records) {
            String[] input = record.split(" ");
            String time = input[0];
            String carNumber = input[1];
            String inOut = input[2];
            if (!carNumberList.contains(carNumber))
                carNumberList.add(carNumber);

            if ("IN".equals(inOut)) {
                Map<String, String> carTimeMap = new HashMap<>();
                carTimeMap.put(inOut, time);
                carRecordMap.put(carNumber, carTimeMap);
                noOutCar.put(carNumber, time);
            } else {
                Map<String, String> carTimeMap = carRecordMap.get(carNumber);
                String cardInTime = carTimeMap.get("IN");
                String[] inSplit = cardInTime.split(":");
                int inHour = Integer.parseInt(inSplit[0]) * 60;
                int inMinute = Integer.parseInt(inSplit[1]);
                int inTime = inHour + inMinute;
                String[] outSplit = time.split(":");
                int outHour = Integer.parseInt(outSplit[0]) * 60;
                int outMinute = Integer.parseInt(outSplit[1]);
                int outTime = outHour + outMinute;

                int spendTime = outTime - inTime;
                cardMoneyMap.put(carNumber, cardMoneyMap.getOrDefault(carNumber,0) + spendTime);
                carTimeMap.remove("IN");
                noOutCar.remove(carNumber);
            }
        }
        Collections.sort(carNumberList);
        for (String s : carNumberList) {
            int spendTime = cardMoneyMap.getOrDefault(s, 0);
            if (noOutCar.containsKey(s)) {
                String s1 = noOutCar.get(s);
                String[] split = s1.split(":");
                int additionTime = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);

                spendTime += (dayEnd - additionTime);
            }
            if (spendTime <= defaultTime)
                answerList.add(defaultMoney);
            else {
                int addTime = spendTime - defaultTime;
                int times = addTime / addtionalTime;
                if (addTime % addtionalTime != 0 ) times++;
                int money = defaultMoney + (addtionalMoney * times);
                answerList.add(money);
            }
        }

        // 정답
        int[] answer = new int[answerList.size()];
        for (int i= 0; i< answer.length; i++) {
            answer [i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                        "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}))); // 14600, 34400, 5000
        System.out.println(Arrays.toString(solution(new int[]{120, 0, 60, 591},
                new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"}))); // 0, 591
        System.out.println(Arrays.toString(solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"}))); // 14841

    }
}
