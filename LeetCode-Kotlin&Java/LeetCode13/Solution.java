package LeetCode13;

/* 13. Roman to Integer*/
import java.util.*;
class Solution {
    public int romanToInt(String s) {
        int [][] image;


        HashMap<String,Integer> map=new HashMap<>();
        int sum=0;
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        s+=" ";
        for(int i=0; i<s.length()-1; i++){
            char l=s.charAt(i);
            char r=s.charAt(i+1);
            String target=l+""+r;
            if (!map.containsKey(target)) {
                sum+=map.get(l+"");
            } else {
                i++;
                sum+=map.get(target);
            }
        }
        return sum;
    }
}
