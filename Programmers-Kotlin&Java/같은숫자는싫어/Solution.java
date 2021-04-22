package 같은숫자는싫어;

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list=new ArrayList<>();
        int now=arr[0];
        list.add(now);
        for(int i=1; i<arr.length; i++){
            if(now!=arr[i]) list.add(arr[i]);
            now=arr[i];
        }
        int[] answer=new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}
