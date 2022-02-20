package 프로그래머스_단체사진_찍기;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Solution {
    static Map<Character, Integer> map = new HashMap<>();
    static int[] dist=new int[8];
    static boolean[] visited=new boolean[8];
    static int answer;

    static String[] temp;
    public static int solution(int n, String[] data) {
        temp=data;
        initSetting();
        dfs(0,data);
        return answer;
    }

    // A C F J M N R T
    public static void initSetting(){
        answer=0;
        map.put('A',0);
        map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);
    }
    public static void dfs(int idx, String[] data){
        if(idx==8){
            if(validation(data)) answer++;
        }else{
            IntStream.range(0, 8)
                    .filter(i -> !visited[i])
                    .forEachOrdered(i -> {
                visited[i] = true;
                dist[idx] = i;
                dfs(idx + 1, data);
                visited[i] = false;
            });
        }
    }
    public static boolean validation(String[] data){
        for (String singleData : data) {
            int from=dist[map.get(singleData.charAt(0))];
            int to=dist[map.get(singleData.charAt(2))];
            char oper = singleData.charAt(3);
            int chai= singleData.charAt(4)-'0'+1;
//            System.out.println("from : "+ from+" to: " + to +" oper: "+oper + " chai: "+chai);
            switch (oper) {
                case '=':
                    if (Math.abs(from - to) != chai) return false;
                    break;
                case '>':
                    if (Math.abs(from - to) <= chai) return false;
                    break;
                default:
                    if (Math.abs(from - to) >= chai) return false;
                    break;
            }
        }
        return true;
    }

}

class Main{
    public static void main(String[] args) {
        System.out.println(Solution.solution(2,new String[]{"N~F=0","R~T>2"})); // 3648
        System.out.println(Solution.solution(2,new String[]{"M~C<2","C~M>1"})); // 0
    }
}
