//백준 - 앱
//다시 푸는 것
package exercise_coding.backjun.backjun20230323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memories = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memories[i] = Integer.parseInt(st.nextToken());
        }

        int[] costs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int sum = Arrays.stream(costs).sum();
        int[] dp = new int[ sum +1 ];

        for (int i = 0; i < N; i++) {
            int memory = memories[i];
            int cost = costs[i];

            for (int j = sum; j-cost >= 0 ; j--) {
                dp[j] = Math.max(dp[j], dp[j-cost] + memory);
            }
            System.out.println(Arrays.toString(dp));
        }

        for (int i = 0; i <= sum; i++) {
            if(dp[i] >= M){
                System.out.println(i);
                return;
            }
        }
    }
}
