//프로그래머스 등굣길 문제
//dp로 도전

package Programmers.pro20230103;

public class exam01_1 {
    final static int MOD = 1000000007;
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2,2}};
        System.out.println(solution(m,n,puddles));
    }
    public static int solution(int m, int n, int[][] puddles) {

        int[][] board = new int[m+1][n+1];

        for (int i = 0; i < puddles.length; i++) {
            board[puddles[i][0]][puddles[i][1]] = -1;
        }

        board[1][1] = 1;
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(board[i][j] == -1) continue;
                if(board[i-1][j] > 0) board[i][j] += board[i-1][j] % MOD;
                if(board[i][j-1] > 0) board[i][j] += board[i][j-1] % MOD;
            }
        }

        return board[m][n] % MOD;
    }
}
