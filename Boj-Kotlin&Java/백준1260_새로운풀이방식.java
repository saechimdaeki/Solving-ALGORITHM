package 백준;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class 백준1260_새로운풀이방식 {
    static ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    static BufferedWriter bw;
    static boolean[] visit;
    static int[] nmv;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        bw=new BufferedWriter(new OutputStreamWriter(System.out));

        nmv= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        IntStream.rangeClosed(0, nmv[0]).forEach(i -> list.add(new ArrayList<>()));
        visit=new boolean[nmv[0]+1];
        for(int i=0; i<nmv[1]; i++){
            int[] ab= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.get(ab[0]).add(ab[1]);
            list.get(ab[1]).add(ab[0]);
        }
        for(int i=1; i<=nmv[0]; i++)
            Collections.sort(list.get(i));
        dfs(nmv[2]);
        bw.write("\n");
        Arrays.fill(visit,false);
        bfs(nmv[2]);
        bw.flush();
    }
    static void dfs(int start) throws IOException {
        visit[start]=true;
        bw.write(start+" ");
        for(int i=0; i<list.get(start).size(); i++)
            if (!visit[list.get(start).get(i)])
                dfs(list.get(start).get(i));
    }
    static void bfs(int start) throws IOException {
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        visit[start]=true;
        while (!q.isEmpty()){
            int now=q.poll();
            bw.write(now+" ");
            for(int i=0; i< list.get(now).size(); i++){
                if(!visit[list.get(now).get(i)]){
                    q.offer(list.get(now).get(i));
                    visit[list.get(now).get(i)]=true;
                }
            }
        }
    }
}
