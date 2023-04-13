package exercise_coding.leetcode.leet20230103;

import java.util.Arrays;

public class exam01 {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(Arrays.toString(countBits(n)));
    }

    public static int[] countBits(int n) {
        if(n < 1){
            return new int[1];
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            if(i%2==0) {
                dp[i] = dp[i/2];
            }else {
                dp[i] = dp[i/2]+1;
            }
        }

        return dp;
    }
}
