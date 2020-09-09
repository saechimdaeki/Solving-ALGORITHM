package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class node10825 implements Comparable<node10825>{
    String name;
    int korean;
    int english;
    int math;

    public node10825(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    @Override
    public int compareTo(node10825 o) {
        if(this.korean>o.korean)
            return -1;
        else if(this.korean==o.korean){
            if(this.english>o.english)
                return 1;
            else if(this.english==o.english){
                if(this.math>o.math)
                    return -1;
                else if(this.math==o.math)
                    return this.name.compareTo(o.name);
                else
                    return 1;
            }
            else
                return -1;
        }
        return 1;
    }
}
public class 백준10825번국영수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        ArrayList<node10825> list=new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] input=br.readLine().split(" ");
            list.add(new node10825(input[0],Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3])));
        }
        Collections.sort(list);
        for(int i=0; i<list.size(); i++)
            bw.write(list.get(i).name+"\n");
        bw.flush();
    }
}
