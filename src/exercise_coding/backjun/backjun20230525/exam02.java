//백준 - 전깃줄
//TODO - 다시
package exercise_coding.backjun.backjun20230525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam02 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        Arrays.fill(dp,1);
        int[][] connected = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            connected[i][0] = Integer.parseInt(st.nextToken());
            connected[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(connected, (x,y) -> x[0] - y[0]);

        for (int i = 0; i < N; i++) {
            /*
             * i번째 전봇대를 기준으로 이전의 전봇대들의
             * 전선을 연결하기 위한 탐색
             * 즉, i번째 전봇대에 연결된 B전봇대는
             * 탐색할 j번째 전봇대에 연결된 B전봇대보다 값이 커야함
             */

            for (int j = 0; j < i; j++) {
                if(connected[i][1] > connected[j][1]){
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        int answer = 0;

        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(N - answer);
    }
}
