package coding_test_exercise.year2022.pro20221205;

public class exam1 {
    static final int mod = 1234567;
    public static void main(String[] args) {
        int n = 3;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int[] dp = new int[n+1];
        if(n <= 1){
            return n;
        }

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-2]%mod + dp[i-1]%mod;
        }

        return dp[n]%mod;
    }
}
