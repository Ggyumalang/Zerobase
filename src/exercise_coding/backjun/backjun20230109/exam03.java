//dp로 풀어봤는데 실패함.

package exercise_coding.backjun.backjun20230109;

import java.util.Arrays;
import java.util.Scanner;

public class exam03 {
    final static int INF = 100000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] dp = new int[K+1];
        Arrays.fill(dp,INF);
        dp[N] = 0;
        dp[N+1] = 1;
        dp[N*2] = 0;

        for (int i = N+2; i <= K-1; i++) {
            dp[i] = Math.min(dp[i-1]+1, Math.min(dp[i+1]+1 , dp[i%2 == 0 ? i/2 : 0]));
            if(i*2 <= K){
                dp[i*2] = Math.min(dp[i*2],dp[i]);
            }
        }

        dp[K] = Math.min(dp[K-1]+1 ,dp[K%2==0? K/2 : 0]);
        System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
        System.out.println(dp[K]);

    }
}
