package 프로그래머스_숫자_문자열과_영단어;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int solution(String s) {
        int answer = 0;
        Map<String,String> map=new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two","2");
        map.put("three","3");
        map.put("four","4");
        map.put("five","5");
        map.put("six","6");
        map.put("seven","7");
        map.put("eight","8");
        map.put("nine","9");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (map.containsKey(entry.getKey()))
                s= s.replaceAll(entry.getKey(), entry.getValue());
        }
        answer=Integer.parseInt(s);

        return answer;
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println(Solution.solution("one4seveneight")); //1478
        System.out.println(Solution.solution("23four5six7")); //234567;
        System.out.println(Solution.solution("2three45sixseven")); //234567;
        System.out.println(Solution.solution("123")); //123
    }
}