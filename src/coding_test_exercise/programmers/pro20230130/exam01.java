//삼각형.
package coding_test_exercise.programmers.pro20230130;

import java.util.Arrays;

public class exam01 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                //맨 왼쪽이면..
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }else if(j == triangle[i].length-1){
                    //맨 오른쪽이면
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }else {
                    //중간값이면
                    dp[i][j] = Math.max(dp[i-1][j-1] , dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        return Arrays.stream(dp[triangle.length-1]).max().getAsInt();
    }
}
