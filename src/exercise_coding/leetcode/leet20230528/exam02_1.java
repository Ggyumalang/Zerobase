//leetCode - Decode Ways
package exercise_coding.leetcode.leet20230528;

import java.util.Arrays;

public class exam02_1 {

    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));

        s = "111111111111111111111111111111111111111111111";
        System.out.println(numDecodings(s));

        s = "06";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n ; i++) {
            int first = Integer.parseInt(s.substring(i-1, i));
            int second = Integer.parseInt(s.substring(i-2, i));

            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }

            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }
}
