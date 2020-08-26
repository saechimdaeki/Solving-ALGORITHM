package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준1543번문서검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine();
        String s2=br.readLine();
        int cnt=0;
        for(int i=0; i<s1.length()-s2.length()+1; i++){
            boolean check=true;
            for(int j=0; j<s2.length(); j++){
                if(s1.charAt(i+j)!=s2.charAt(j)){
                    check=false;
                    break;
                }
            }
            if(check){
                i+=s2.length()-1;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
