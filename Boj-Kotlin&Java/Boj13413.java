import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj13413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        ArrayList<Integer> answerList=new ArrayList<>();
        while (t-->0){
            int n=Integer.parseInt(br.readLine());
            String first=br.readLine();
            String second=br.readLine();
            answerList.add(calc(n,first,second));
        }
        answerList.forEach(System.out::println);
    }
    static int calc(int n,String f,String s){
        int black=0; int white=0;
        for(int i=0; i<n; i++){
            if(f.charAt(i)!=s.charAt(i)){
                if (f.charAt(i) == 'W') white++;
                else black++;
            }
        }
        return Math.max(black,white);
    }
}

