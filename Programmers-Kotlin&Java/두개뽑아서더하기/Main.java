package 프로그래머스.두개뽑아서더하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

class Solution {
    public int[] solution(int[] numbers) {
        Arrays.sort(numbers);
        HashSet<Integer> set=new HashSet<>();
        for(int i=0; i< numbers.length-1; i++){
            for(int j=i+1; j< numbers.length; j++){
                int sum=numbers[i]+numbers[j];
                set.add(sum);
            }
        }
        ArrayList<Integer> arr=new ArrayList<>(set);
        Collections.sort(arr);
        int[] answer=new int[arr.size()];
        for(int i=0; i<arr.size(); i++)
            answer[i]=arr.get(i);
        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] answer1=s.solution(new int[]{2,1,3,4,1});
        for(int i:answer1)
            System.out.print(i+" ");
        System.out.println();
        int[] answer2=s.solution(new int[]{5,0,2,7});
        for(int i:answer2)
            System.out.print(i+" ");
    }
}
