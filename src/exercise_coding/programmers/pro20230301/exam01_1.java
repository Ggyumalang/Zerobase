//깡으로 풀었는데 실패.
//프로그래머스 보행자 천국
//다음에 풀어보자
package exercise_coding.programmers.pro20230301;

import java.util.Arrays;

public class exam01_1 {
    public static void main(String[] args) {
        int m = 3, n = 3;
        int[][] cityMap = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(solution(m,n,cityMap));

        m = 3;
        n = 6;
        cityMap = new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        System.out.println(solution(m,n,cityMap));
    }

    static int MOD = 20170805;
    public static int solution(int m, int n, int[][] cityMap) {

        // dp[][][0] 아래쪽, dp[][][1] 오른쪽
        int[][][] dp = new int[m+1][n+1][2];

        dp[1][1][0] = dp[1][1][1] = 1;

        for (int r = 1; r <= m ; r++) {
            for (int c = 1; c <= n ; c++) {
                if(cityMap[r-1][c-1] == 0){
                    dp[r][c][0] += (dp[r-1][c][0] + dp[r][c-1][1]) % MOD;
                    dp[r][c][1] += (dp[r-1][c][0] + dp[r][c-1][1]) % MOD;
                } else if (cityMap[r-1][c-1] == 1) {
                    dp[r][c][0] = 0;
                    dp[r][c][1] = 0;
                } else {
                    dp[r][c][0] = dp[r-1][c][0];
                    dp[r][c][1] = dp[r][c-1][1];
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[m][n][0];
    }
}
