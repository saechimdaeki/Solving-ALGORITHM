package LeetCode1807;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/* 1807. Evaluate the Bracket Pairs of a String */
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map= knowledge.stream().collect(Collectors.toMap(strings -> strings.get(0), strings -> strings.get(1), (a, b) -> b, HashMap::new));
        StringBuffer sb=new StringBuffer();
        StringBuffer tmp=new StringBuffer();
        boolean check=false;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') check = true;
            else if(s.charAt(i)==')'){
                sb.append(map.getOrDefault(tmp.toString(),"?"));
                tmp=new StringBuffer();
                check=false;
            }else{
                if(!check)
                sb.append(s.charAt(i));
                else
                    tmp.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

