//백준 13305번 주유소 그리디 알고리즘
package exercise_coding.year2022.backjun20221219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] distance = new long[N-1];
        for (int i = 0; i < N-1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long[] gasCost = new long[N];
        for (int i = 0; i < N; i++) {
            gasCost[i] = Long.parseLong(st.nextToken());
        }

        long cost = 0;
        long minCost = gasCost[0];

        for (int i = 0; i < N-1; i++){
            if(minCost > gasCost[i]){
                minCost = gasCost[i];
            }
            cost += distance[i] * minCost;
        }

        System.out.println(cost);



    }
}
