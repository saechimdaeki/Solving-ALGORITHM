package 진정한_효도;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[3][3];
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            int[] row = map[i];
            int[] col = { map[0][i], map[1][i], map[2][i] };

            Arrays.sort(row);
            Arrays.sort(col);

            int rowDist = Math.abs(row[1] - row[0]) + Math.abs(row[1] - row[2]);
            int colDist = Math.abs(col[1] - col[0]) + Math.abs(col[1] - col[2]);

            min = Math.min(min, Math.min(rowDist, colDist));
        }

        System.out.println(min);
    }
}
