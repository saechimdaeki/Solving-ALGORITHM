package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준7453번합이0인네정수 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] a=new int[n];
        int[] b=new int[n];
        int[] c=new int[n];
        int[] d=new int[n];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            a[i]=Integer.parseInt(st.nextToken());
            b[i]=Integer.parseInt(st.nextToken());
            c[i]=Integer.parseInt(st.nextToken());
            d[i]=Integer.parseInt(st.nextToken());
        }
        int[] first=new int[n*n];
        int[] second=new int[n*n];
        int tmp=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                first[tmp]=a[i]+b[j];
                second[tmp]=c[i]+d[j];
                tmp++;
            }
        }
        Arrays.sort(second);
        long answer=0;
        for(int i:first){
            int l=lower_bound(second,-i);
            int u=upper_bound(second,-i);
            answer+=(u-l);
        }
        System.out.println(answer);
    }
   static int upper_bound(int[] a, int val) {
        int left = 0;
        int right = a.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid] <= val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    static int lower_bound(int[] a, int val) {
        int left = 0;
        int right = a.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid] >= val) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
