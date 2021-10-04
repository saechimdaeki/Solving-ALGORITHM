package LeetCode22;

import java.util.ArrayList;
import java.util.List;

/* 22. Generate Parentheses */
public class Solution {
    /* 1<= n <= 8 */
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        tailrec(n,n,"",list);
        return list;
    }

    private void tailrec(int o, int c, String now, List<String> list) {
        if(o==0 && c==0){
            list.add(now);
            return;
        }
        if(o>0)
            tailrec(o-1,c,now+"(",list);
        if(c>o)
            tailrec(o,c-1,now+")",list);
    }
}
