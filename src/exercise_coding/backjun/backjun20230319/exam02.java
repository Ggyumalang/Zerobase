//백준 - 앱
//https://dragon-h.tistory.com/9

package exercise_coding.backjun.backjun20230319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] bytes = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bytes[i] = Integer.parseInt(st.nextToken());
        }

        int[] costs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int sum = Arrays.stream(costs).sum();
        int[] dp = new int[sum +1];

        for (int i = 0; i < N; i++) {
            int memory = bytes[i];
            int cost = costs[i];
            for (int j = sum; j >= cost; j--) {
                dp[j] = Math.max(dp[j - cost] + memory , dp[j]);
            }
            System.out.println(Arrays.toString(dp));
        }
    }
}
