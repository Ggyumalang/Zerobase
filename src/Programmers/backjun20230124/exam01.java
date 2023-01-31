package Programmers.backjun20230124;

import java.util.Arrays;
import java.util.Scanner;

public class exam01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N == 1) {
            System.out.println(10);
            return;
        }

        int[][] dp = new int[N+1][10];
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9 ; j++) {
                for (int k = j; k <= 9 ; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 1007;
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));

        int sum = Arrays.stream(dp[N]).sum();
        System.out.println(sum);
    }
}
