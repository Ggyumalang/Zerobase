package Programmers.year2022.pro20221130;

public class Exam1 {
    final static int mod = 1234567;
    public static void main(String[] args) {
        int n = 100000;
        System.out.println(solution(n));
    }

//    public static int solution(int n) {
//        long[] dp = new long[n+1];
//        long answer = 0;
//        dp[0] = 0;
//        dp[1] = 1;
//
//        for (int i = 2; i <= n ; i++) {
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//
//
//        return (int)dp[n]%mod;
//    }

    public static long solution(int n) {

        int[] dp = new int[n<2 ? 2 : n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int sum = dp[i - 1] + dp[i - 2];
            dp[i] = sum % mod;
        }

        return dp[n]%mod;
    }

//    public static int solution(int n) {
//        if(n <= 1) {
//            return n;
//        }else {
//            return solution(n-1) + solution(n-2);
//        }
//    }
}
