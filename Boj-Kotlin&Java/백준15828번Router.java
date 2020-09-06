package 백준;

import java.io.*;
import java.util.*;

public class 백준15828번Router {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q=new LinkedList<>();
        int n=Integer.parseInt(br.readLine()); //qsize
        while (true){
            int number=Integer.parseInt(br.readLine());
            if(number==-1)
                break;
            if(number==0)
                q.poll();
            else {
                if(q.size()<n)
                q.offer(number);
            }
        }
        if(q.size()==0)
            bw.write("empty");
        else {
            while (!q.isEmpty()){
                bw.write(q.poll()+" ");
            }
        }
        bw.flush();
    }
}
