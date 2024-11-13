package 금고털이;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Jewel> jewels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(weight, cost));
        }

        jewels.sort((j1, j2) -> Integer.compare(j2.cost, j1.cost));

        int answer = 0;
        for (Jewel jewel : jewels) {
            int weight = jewel.weight;
            int cost = jewel.cost;
            if (w <= weight) {
                answer += w * cost;
                break;
            } else {
                answer += weight * cost;
                w -= weight;
            }
        }

        System.out.println(answer);
    }

    static class Jewel {
        int weight;
        int cost;

        public Jewel(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }
    }
}

