package exercise_coding.backjun.backjun20230104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam02 {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        int[] dp = new int[K+1];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        cnt = 0;
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= K ; j++) {
                if(j >= coins[i]){
                    dp[j] += dp[j-coins[i]];
                }
            }
            System.out.println(Arrays.toString(dp));
        }

        System.out.println(dp[K]);
    }
}
