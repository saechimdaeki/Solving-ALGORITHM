package LeetCode1415;

import java.util.ArrayList;
import java.util.List;

/* 1415. The k-th Lexicographical String of All Happy Strings of Length n */
class Solution {
    public String getHappyString(int n, int k) {
        List<String> list=new ArrayList<>();
        track("abc",n,"",list);
        return list.size()>=k ? list.get(k-1): "";
    }
    public void track(String abc, int n, String now,List<String> list){
        if(now.length()==n){
            list.add(now);
            return;
        }
        for(int i=0; i<abc.length(); i++){
            if(now.length()>0 && now.charAt(now.length()-1)==abc.charAt(i)) continue;
            track(abc,n,now+abc.charAt(i),list);
        }
    }

}
