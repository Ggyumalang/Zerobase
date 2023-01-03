//프로그래머스 등굣길 문제
//BackTracking으로 해봤는데 실패.

package Programmers.pro20230103;

import java.util.Arrays;

public class exam01 {
    static int[][] dirs = {{1,0},{0,1}};
    static int[][] board;
    static boolean[][] visited;
    static int cnt;
    final static int MOD = 1000000007;
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};
        System.out.println(solution(m,n,puddles));
    }
    public static int solution(int m, int n, int[][] puddles) {

        board = new int[m+1][n+1];
        visited = new boolean[m+1][n+1];
        cnt = 0;

        for (int i = 0; i < puddles.length; i++) {
            board[puddles[i][0]][puddles[i][1]] = 1;
        }

        dfs(1,1);


        System.out.println(Arrays.deepToString(board));
        return cnt % MOD;
    }

    public static void dfs(int x , int y){
        if(x == board.length-1 && y == board[0].length-1){
            cnt++;
            System.out.println(cnt);
            return;
        }

        for(int[] dir : dirs){
            int xNext = x+dir[0];
            int yNext = y+dir[1];

            if(xNext < 0 || yNext < 0 || xNext >= board.length || yNext >= board[x].length){
                continue;
            }

            if(visited[xNext][yNext]){
                continue;
            }

            if(board[xNext][yNext] != 1){
                visited[xNext][yNext] = true;
                dfs(xNext,yNext);
                visited[xNext][yNext] = false;
            }
        }
    }
}
