//백준 11054번 가장 긴 바이토닉 부분수열

package exercise_coding.backjun.backjun20230105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;
        int[] rDp = new int[N];
        rDp[N-1] = 1;

        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = i-1; j >= 0 ; j--) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
            }
        }

        for (int i = N-2; i >= 0; i--) {
            rDp[i] = 1;
            for (int j = i+1; j < N ; j++) {
                if(nums[i] > nums[j]){
                    rDp[i] = Math.max(rDp[i] , rDp[j] + 1);
                }
            }
        }

        int[] total = new int[N];
        for (int i = 0; i < N; i++) {
            total[i] = dp[i]+rDp[i]-1;
        }

        System.out.println(Arrays.stream(total).max().getAsInt());
    }
}
