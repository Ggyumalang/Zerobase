//백준 1520번 내리막길
//그냥 무작정 dp로 풀려다가 실패
package exercise_coding.backjun.backjun20230206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int[][] dp = new int[M][N];
        dp[0][0] = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for(int[] dir : dirs){
                    int nx = i + dir[0];
                    int ny = j + dir[1];

                    if(nx < 0 || ny < 0 || nx >= M || ny >= N){
                        continue;
                    }
                    if(map[i][j] > map[nx][ny]){
                        dp[nx][ny] += dp[i][j];
                    }

                }
            }
        }
        System.out.println("Arrays.deepToString(dp) = " + Arrays.deepToString(dp));
    }
}
