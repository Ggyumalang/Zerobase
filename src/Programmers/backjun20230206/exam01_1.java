//백준 1520번 내리막길
//dfs + dp를 이용한 문제.
package Programmers.backjun20230206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam01_1 {
    static int[][] mapCopy;
    static int[][] dp;
    static int m;
    static int n;
    final static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        mapCopy = map;
        m = M;
        n = N;
        System.out.println(dfs(0,0));
    }

    public static int dfs(int x,int y){
        if(x == m-1 && y == n-1){
            return 1;
        }

        if(dp[x][y] != -1){
            return dp[x][y];
        }
        dp[x][y] = 0;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                continue;
            }

            if (mapCopy[x][y] > mapCopy[nx][ny]) {
                dp[x][y] += dfs(nx,ny);
            }
        }
        return dp[x][y];
    }
}
