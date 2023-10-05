package 자바.softeer.전광판;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;


public class Main {


    public static void main(String args[]) throws IOException {
        Map<Character, String> map = new HashMap<>();
        map.put('0', "1110111");
        map.put('1', "0010010");
        map.put('2', "1011101");
        map.put('3', "1011011");
        map.put('4', "0111010");
        map.put('5', "1101011");
        map.put('6', "1101111");
        map.put('7', "1110010");
        map.put('8', "1111111");
        map.put('9', "1111011");
        map.put(' ', "0000000");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Integer> answerList = new ArrayList<>();
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            String from = input[0];
            String to = input[1];
            int cnt = 0;
            String fromString = String.format("%5s", from);
            String toString = String.format("%5s", to);
            cnt+=diff(fromString, toString, map);

            answerList.add(cnt);
        }
        answerList.stream().forEach(System.out::println);
    }

    static int diff(String fromString, String toString, Map<Character, String> map) {
        int answer = 0 ;
        for (int i = 0; i < 5; i ++) {
            char from = fromString.charAt(i);
            char to = toString.charAt(i);
            String fromS = map.get(from);
            String toS = map.get(to);
            answer += (int) IntStream.range(0, fromS.length()).filter(j -> fromS.charAt(j) != toS.charAt(j)).count();
        }
        return answer;
    }
}
