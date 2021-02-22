import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj4485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<String> arr=new ArrayList<>();
        while (n-->0) {
            arr.add(br.readLine());
        }
        arr.stream()
                .map(i -> Character.toUpperCase(i.charAt(0))+i.substring(1))
                .forEach(System.out::println);
    }
}
