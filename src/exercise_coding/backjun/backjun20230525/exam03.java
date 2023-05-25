//백준 - 구간 합 구하기 5
package exercise_coding.backjun.backjun20230525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam03 {

    static int[][] board;
    static int[] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N+1][N+1];
        dp = new int[N*N+1];

        int[][] ints = new int[M][4];
        int idx = 1;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[idx] = dp[idx-1] + board[i][j];
                idx++;
            }
        }
        int[] answer = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                ints[i][j] = Integer.parseInt(st.nextToken());
            }
            answer[i] = getNum(ints[i]);
        }

        for (int i = 0; i < M; i++) {
            System.out.println(answer[i]);
        }



    }

    private static int getNum(int[] ints) {
        int x1 = ints[0];
        int y1 = ints[1];
        int x2 = ints[2];
        int y2 = ints[3];

        if(x1 == x2 && y1 == y2) {
            return board[x1][y1];
        }

        int idx1 = N * (x1 - 1) + y1;
        int idx2 = N * (x2 - 1) + y2;
        int answer = 0;
        if(idx1 == 0) {
            return dp[idx2] - dp[idx1] + 1;
        }
        idx1--;
        answer = dp[idx2] - dp[idx1];
        if (y1 != 1) {
            for (int i = 1; i < y1; i++) {
                answer -= board[x2][i];
            }
        }

        if(y2 != N) {
            for (int i = y2; i <= N; i++) {
                answer -= board[x1][i];
            }
        }

        return answer;
    }
}
