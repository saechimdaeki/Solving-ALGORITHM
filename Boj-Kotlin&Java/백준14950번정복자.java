package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class node14950 implements Comparable<node14950>{
    int x,y,dist;

    public node14950(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(node14950 o) {
        if(this.dist<o.dist)
            return -1;
        return 1;
    }
}

public class 백준14950번정복자 {
    static int n,m,t;
    static int answer=0;
    static int[] parent;
    static ArrayList<node14950> list=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmt=br.readLine().split(" ");
        n=Integer.parseInt(nmt[0]);
        m=Integer.parseInt(nmt[1]);
        t=Integer.parseInt(nmt[2]);
        parent=new int[n+1];
        for(int i=1; i<=n; i++)
            parent[i]=i;
        for(int i=0; i<m; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int dist=Integer.parseInt(st.nextToken());
            list.add(new node14950(x,y,dist));
        }
        Collections.sort(list);
        for (node14950 temp : list) {
            if (find(temp.x) != find(temp.y)) {
                union(temp.x, temp.y);
                answer += temp.dist;
            }
        }
        int tmp=((n-2)*(n-1))/2;
        answer+=tmp*t;
        System.out.println(answer);
    }
    static int find(int x){
        if(parent[x]==x)
            return x;
        return parent[x]=find(parent[x]);
    }
    static void union(int x, int y){
        int px=parent[x];
        int py=parent[y];
        if(px<py)
            parent[py]=px;
        else
            parent[px]=py;
    }
}
