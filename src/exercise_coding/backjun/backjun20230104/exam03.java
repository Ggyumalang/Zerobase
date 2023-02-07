package exercise_coding.backjun.backjun20230104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam03 {
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    static int ans;
    static int[][] board;
    static int[][] dp;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            String[] input = st.nextToken().split("");
            for (int j = 0; j < M ; j++) {
                if(input[j].equals("H")) input[j] = "-2";
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        dfs(0,0 , 1);
        System.out.println(ans);
    }

    private static void dfs(int x, int y , int cnt) {
        dp[x][y] = cnt;
        ans = Math.max(ans,cnt);

        for(int[] dir : dirs){
            int xNext = x+dir[0]*board[x][y];
            int yNext = y+dir[1]*board[x][y];

            if(xNext < 0 || yNext < 0 || xNext >= board.length || yNext >= board[x].length){
                continue;
            }

            if(board[xNext][yNext] == -2){
                continue;
            }

            //이미 다음 지점까지 가기 위해 게임한 횟수가 현재 지점에서 한번 더 한것 보다 크다면 어차피 작으므로 할 이유 x
            if(cnt < dp[xNext][yNext]){
                System.out.println("cnt = " + cnt);
                System.out.println("xNext = " + xNext);
                System.out.println("yNext = " + yNext);
                System.out.println("dp[xNext][yNext] = " + dp[xNext][yNext]);
                continue;
            }

            if(visited[xNext][yNext]){
                ans = -1;
                System.out.println(ans);
                System.exit(0);
            }

            visited[xNext][yNext] = true;
            dfs(xNext , yNext , cnt+1);
            visited[xNext][yNext] = false;
        }
    }


}
