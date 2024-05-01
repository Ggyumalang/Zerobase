//백준 5557번 1학년 - 골드5
//방식 2 - 참고..
package exercise_coding.backjun.back20240412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int limitNum = 20;

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n][21];
        dp[0][arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 21; j++) {
                int plusVal = j + arr[i];
                int minusVal = j - arr[i];

                if (plusVal <= 20 && dp[i - 1][j] != 0) {
                    dp[i][plusVal] += dp[i - 1][j];
                }

                if (minusVal >= 0 && dp[i - 1][j] != 0) {
                    dp[i][minusVal] += dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n - 2][arr[n - 1]]);
    }
}
