package 백준;

import java.io.*;

public class 백준1991번트리순회 {
    static int n;
    static class node{
        String x,y;
        public node(String x, String y) {
            this.x = x;
            this.y = y;
        }
    }
    static node[] nodes;
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        nodes=new node[n+1];
        for(int i=0; i<n+1; i++)
            nodes[i]= new node("","");
        while (n-->0){
            String[] abc= br.readLine().split(" ");
            nodes[abc[0].charAt(0)-'A'].x=abc[1];
            nodes[abc[0].charAt(0)-'A'].y=abc[2];
        }
        preorder("A");
        bw.write("\n");
        inorder("A");
        bw.write("\n");
        postorder("A");
        bw.flush();
    }
    static void preorder(String start) throws IOException {
        if(start.equals(".")) return;
        bw.write(start);
        preorder(nodes[start.charAt(0)-'A'].x);
        preorder(nodes[start.charAt(0)-'A'].y);
    }
    static void inorder(String start) throws IOException {
        if(start.equals(".")) return;
        inorder(nodes[start.charAt(0)-'A'].x);
        bw.write(start);
        inorder(nodes[start.charAt(0)-'A'].y);
    }
    static void postorder(String start) throws IOException {
        if(start.equals(".")) return;
        postorder(nodes[start.charAt(0)-'A'].x);
        postorder(nodes[start.charAt(0)-'A'].y);
        bw.write(start);
    }

}
