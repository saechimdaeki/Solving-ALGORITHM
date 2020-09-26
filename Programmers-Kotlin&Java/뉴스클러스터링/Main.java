package 프로그래머스.뉴스클러스터링;


import java.util.ArrayList;
import java.util.Collections;

class Solution {
    //65536
    public int solution(String str1, String str2) {
        ArrayList<String> ALL=new ArrayList<>();
        ArrayList<String> arr1=new ArrayList<>();
        ArrayList<String> common=new ArrayList<>();
        ArrayList<String> arr2=new ArrayList<>();
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        addSomething(str1, arr1);
        addSomething(str2, arr2);
        Collections.sort(arr1);
        Collections.sort(arr2);
        for(String s: arr1){
            if(arr2.contains(s)){
                common.add(s);
                arr2.remove(s);
            }
            ALL.add(s);
        }
        ALL.addAll(arr2);
        double answer=0;
        if (ALL.size() != 0) {
            if (common.size() == 0) answer = 0;
            else {
                answer = (double) common.size() / (double) ALL.size();
            }
            return (int) (answer * 65536);
        } else {
            return 65536;
        }
    }
    public void addSomething(String str, ArrayList<String> arr) {
        for(int i=0; i<str.length()-1; i++){
            char temp1=str.charAt(i);
            char temp2=str.charAt(i+1);
            if(temp1>='a' && temp1<='z' && temp2>='a' && temp2<='z')
                arr.add(temp1+Character.toString(temp2));
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution("FRANCE","french"));
        System.out.println(s.solution("handshake","shake hands"));
        System.out.println(s.solution("aa1+aa2","AAAA12"));
        System.out.println(s.solution("E=M*C^2","e=m*c^2"));
        //System.out.println(s.solution("a","b"));
       // System.out.println(s.solution("a","b"));

    }
}
