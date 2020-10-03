package 프로그래머스.단어변환;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    ArrayList<Integer> arrayList=new ArrayList<>();
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited=new boolean[words.length];
        dfs(begin,target,words,0);
        Collections.sort(arrayList);
        return arrayList.size() == 0 ? 0 : arrayList.get(0);
    }
    public void dfs(String begin,String target,String[] words,int cnt){
        //  System.out.println(begin);
        if(begin.equals(target)) {
            arrayList.add(cnt);
            return;
        }
        if(cnt> words.length) return;
        for(int i=0; i< words.length; i++){
            if(!visited[i]&& usado(begin,words[i])){
                visited[i]=true;
                dfs(words[i], target,words,cnt+1);
                visited[i]=false;
            }
        }
    }
    public boolean usado(String begin,String compare){
        int cnt=0;
        for(int i=0; i<begin.length(); i++){
            if(begin.charAt(i)!=compare.charAt(i))
                cnt++;
        }
        return cnt == 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        //System.out.println(s.solution("hit","cog",new String[]{"hot","dot","dog","lot","log","cog"}));
        System.out.println(s.solution("hit","cog",new String[]{"hot","dog","dog","lot","log"}));
    }
}
