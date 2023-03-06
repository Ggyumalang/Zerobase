//깡으로 풀었는데 실패.
//프로그래머스 보행자 천국
//다음에 풀어보자
package exercise_coding.programmers.pro20230301;

import java.util.Arrays;

public class exam01_2 {
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
        int[][][] dp = new int[m+1][n+1][2];
        dp[1][1][0] = dp[1][1][1] = 1;

        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(cityMap[i-1][j-1] == 0){
                    dp[i][j][0] += (dp[i-1][j][0] + dp[i][j-1][1])%MOD;
                    dp[i][j][1] += (dp[i-1][j][0] + dp[i][j-1][1])%MOD;
                } else if (cityMap[i-1][j-1] == 1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                }else{
                    dp[i][j][0] = dp[i-1][j][0];
                    dp[i][j][1] = dp[i][j-1][1];
                }
            }
        }

        return dp[m][n][1];
    }
}
