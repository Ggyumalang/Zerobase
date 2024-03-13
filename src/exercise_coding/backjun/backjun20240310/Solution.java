//백준 1463번 - 1로 만들기
//최소공배수인 6을 처리해야한다는 것!
package exercise_coding.backjun.backjun20240310;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            //3으로 나누어 떨어진다면? 이전값에 + 1 한게 더 큰지 ? 비교 후 몫으로 값을한다.
            if ( i % 6 == 0) {
              dp[i] = Math.min(dp[i/3] + 1 , Math.min(dp[i/2] + 1 , dp[i-1] + 1));
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 3] + 1);
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[n]);

    }
}
