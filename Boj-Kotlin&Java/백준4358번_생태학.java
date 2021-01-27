package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 백준4358번_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String,Integer> map=new HashMap<>();
        ArrayList<String> list=new ArrayList<>();
        String input="";
        int cnt=0;
        while((input=br.readLine())!=null){
            if(!map.containsKey(input)) {
                map.put(input, 1);
                list.add(input);
            }
            else
            map.put(input, map.get(input) + 1);
            cnt++;
        }
        Collections.sort(list);
        for (String s : list) {
            bw.write(s+" "+String.format("%.4f",(double)(map.get(s)*100)/cnt)+"\n");
//            double answer = Math.round(((double)map.get(s) / cnt) * 1000000) / 10000.0;
//            bw.write(s+" "+answer+"\n");
        }
        bw.flush();
    }
}
