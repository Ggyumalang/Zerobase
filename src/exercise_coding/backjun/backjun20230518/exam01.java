//백준 - 동전 2
package exercise_coding.backjun.backjun20230518;

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
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] dp = new int[K+1];
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = arr[i]; j <= K ; j++) {
                dp[j] = Math.min(dp[j] , dp[j - arr[i]]+1);
            }
            System.out.println(Arrays.toString(dp));
        }

        System.out.println(dp[K] == (int)1e9 ? -1 : dp[K]);

    }

}
