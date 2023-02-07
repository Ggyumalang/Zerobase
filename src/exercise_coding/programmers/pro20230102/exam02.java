package exercise_coding.programmers.pro20230102;

import java.util.Arrays;

public class exam02 {
    public static void main(String[] args) {
        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            //맨 왼쪽
            dp[i][0] = dp[i-1][0] + triangle[i][0];

            //중간
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-1]) + triangle[i][j];
            }

            //맨 끝
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }
        System.out.println(Arrays.deepToString(dp));
        return Arrays.stream(dp[dp.length-1]).max().getAsInt();
    }
}
