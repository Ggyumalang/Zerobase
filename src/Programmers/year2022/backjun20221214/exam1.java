package Programmers.year2022.backjun20221214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        //모든 수를 돈다.
        for (int i = 0; i < N; i++) {
            //모든 부분은 자신을 포함한 1부터 시작하므로..
            dp[i] = 1;

            //i보다 적은 범위에서 확인한다 i 보다 작은 수가 있었는지?
            for (int j = 0; j < i; j++) {
                if(seq[i] > seq[j] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
