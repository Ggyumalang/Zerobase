//leetCode - Climbing Stairs
package exercise_coding.leetcode.leet20230528;

import java.util.Arrays;

public class exam01 {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];
    }

}
