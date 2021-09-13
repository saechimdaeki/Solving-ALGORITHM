package LeetCode1967;

import java.util.*;
/* 1967. Number of Strings That Appear as Substrings in Word */
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count= 0;
        for(int i=0; i<patterns.length; i++){
            if(word.contains(patterns[i]))
                count++;
        }
        return count;
    }
}
