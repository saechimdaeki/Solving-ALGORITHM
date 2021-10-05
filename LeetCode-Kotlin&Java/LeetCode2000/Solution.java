package LeetCode2000;

public class Solution {
    public String reversePrefix(String word, char ch) {
       StringBuilder sb=new StringBuilder();
        int idx = word.indexOf(ch);
        sb.append(word, 0, idx+1);
        sb.reverse();
        sb.append(word.substring(idx+1));
        return sb.toString();
    }
}
