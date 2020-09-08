package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class node implements Comparable<node> {
    int x,y,dist;
    public node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
    @Override
    public int compareTo(node o) {
        return this.dist-o.dist;
    }
}

public class 백준10423번전기가부족해 {
    static int[] parent;
    static ArrayList<node> list=new ArrayList<>();
    static int[] arr;
    static int n,m,k;
    static StringTokenizer st;
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        n=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1]);
        k=Integer.parseInt(input[2]);
        arr=new int[k];
        parent=new int[n+1];
        for(int i=1; i<=n; i++)
            parent[i]=i;
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            parent[arr[i]]=0;
        }
        for(int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int dist=Integer.parseInt(st.nextToken());
            list.add(new node(x,y,dist));
        }
        Collections.sort(list);
        for (node tmp : list) {
            if (find(tmp.x) != find(tmp.y)) {
                answer += tmp.dist;
                union(tmp.x, tmp.y);
            }
        }
        System.out.println(answer);
    }
    static int find(int x){
        if(parent[x]==0)
            return 0;
        if(x==parent[x])
            return x;
        return parent[x]=find(parent[x]);
    }
    static void union(int x, int y){
        int px=find(x);
        int py=find(y);
        if(px<py)
            parent[py]=px;
        else
            parent[px]=py;
    }
}
