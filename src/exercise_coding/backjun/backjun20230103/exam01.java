package exercise_coding.backjun.backjun20230103;

import java.util.Scanner;

public class exam01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if(N % 5 == 0){
            System.out.println(N/5);
            return;
        }
        int[] dp = new int[N/5+1];
        int[] dp3 = new int[N/3+1];
        dp[0] = N;
        dp3[0] = N;
        int answer = Integer.MAX_VALUE;

        if(N % 3 == 0){
            answer = N/3;
        }

        for (int i = 1; i <= N/5; i++) {
            dp[i] = dp[i-1] - 5;
            if(dp[i]%3 == 0){
                answer = Math.min(i+dp[i]/3,answer);
                break;
            }
        }

        for (int i = 1; i <= N/3 ; i++) {
            dp3[i] = dp3[i-1] - 3;
            if(dp3[i]%5 == 0){
                answer = Math.min(i+dp3[i]/5,answer);
                break;
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}
