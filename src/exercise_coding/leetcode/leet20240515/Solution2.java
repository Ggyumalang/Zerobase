//leetCode 70. Climbing Stairs
package exercise_coding.leetcode.leet20240515;

public class Solution2 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;

        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
