package LeetCode693;

class Solution {
    public boolean hasAlternatingBits(int n) {
        String s=Integer.toBinaryString(n);
        char now=s.charAt(0);
        for(int i=1; i<s.length(); i++){
            if(now==s.charAt(i)) return false;
            now=s.charAt(i);
        }
        return true;
    }
}
