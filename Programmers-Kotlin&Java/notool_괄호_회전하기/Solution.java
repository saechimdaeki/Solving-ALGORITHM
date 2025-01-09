package programmers.notool_괄호_회전하기;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String newString = s + s;
        
        for (int i = 0; i < s.length(); i++) {
            String temp = newString.substring(i, i + s.length());
            
            if (valid(temp))
                answer++;
        }
        
        return answer;
    }
    public boolean valid(String temp) {
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < temp.length(); i ++) {
            char now = temp.charAt(i);
            if (now == '(' || now == '{' || now == '[')
                st.push(now);
            else {
                if (st.isEmpty())
                    return false;
                else if ((now ==')' && st.peek() != '(' ) ||
                        (now==']' && st.peek() != '[') ||
                         (now=='}' && st.peek() != '{')
                        )
                    return false;
                else
                    st.pop();
            }
        }
        return st.isEmpty();
    }
}