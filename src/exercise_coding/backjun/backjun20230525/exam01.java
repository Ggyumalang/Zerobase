//백준 - 타일 채우기
//어려움.. 틀렸음 => 05.26 다시 풀이 예정
//아직도 잘 이해가 안감.. 이런 건 직접 그려가면서 풀어가야하나 봄..
//TODO - 다시
package exercise_coding.backjun.backjun20230525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N % 2 != 0){
            System.out.println(0);
            return;
        }

        int[] dp = new int[N+1];
        int accumulate = 0;
        dp[2] = 3;
        for (int i = 4; i <= N; i+=2) {
            accumulate += dp[i-4] * 2 ; //예외상황
            dp[i] = dp[i-2] * 3 + 2 + accumulate;
        }

        System.out.println(dp[N]);
    }

}
