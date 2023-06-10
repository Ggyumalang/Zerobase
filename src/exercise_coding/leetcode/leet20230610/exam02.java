//leetCode Perfect Squares
package exercise_coding.leetcode.leet20230610;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class exam02 {

    public static void main(String[] args) {
        int n = 13;
        System.out.println(numSquares(n));
        n = 6;
        System.out.println(numSquares(n));
    }
    public static int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            int square = i*i;
            if(square < n){
                list.add(square);
            }else if(square == n) {
                return 1;
            }
        }

        System.out.println(list);
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int var : list) {
            for (int j = 2; j <= n; j++) {
                if (j % var == 0) {
                    dp[j] = Math.min(dp[j], j / var);
                }else if(j-var > 0){
                    dp[j] = Math.min(dp[j], dp[j-var] + dp[var]);
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];
    }
}
