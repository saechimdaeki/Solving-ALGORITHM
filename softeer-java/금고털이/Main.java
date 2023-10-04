package 자바.softeer.금고털이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Material> materials = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            materials.add(new Material(p, m));
        }

        materials.sort(Comparator.comparing(m -> m.price, Comparator.reverseOrder()));
        int answer = 0;

        for (int i = 0; i< materials.size(); i++) {
            Material material = materials.get(i);
            if (w > material.weight)
                answer += (material.price * material.weight);
            else {
                answer += (material.price * w);
                break;
            }
            w -= material.weight;
        }
        System.out.println(answer);
    }
}

class Material {
    int price;
    int weight;

    public Material(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

}