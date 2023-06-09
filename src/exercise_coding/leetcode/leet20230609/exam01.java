//LeetCode - surrounded Regions
package exercise_coding.leetcode.leet20230609;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class exam01 {

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);

        board = new char[][]{{'X'}};
        solve(board);

        board = new char[][]{{'X','X','X'}, {'X','O','X'}, {'X','X','X'}};
        solve(board);
    }
    static int N, M;
    static char[][] boardCopy;
    final static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void solve(char[][] board) {
        M = board.length;
        N = board[0].length;
        boardCopy = new char[M][N];

        for (int i = 0; i < M; i++) {
            System.arraycopy(board, 0 , boardCopy, 0, N);
        }

        if(N == 1 || M == 1) {
            return;
        }

        for (int i = 1; i < M-1; i++) {
            for (int j = 1; j < N-1; j++) {
                if(board[i][j] == 'O'){
                    bfs(i,j);
                }
            }
        }

        System.out.println(Arrays.deepToString(boardCopy));

    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{i,j});
        queue.add(new int[]{i,j});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            for(int[] dir : dirs) {
                int nX = x + dir[0];
                int nY = y + dir[1];

                if(nX < 0 || nY < 0 || nX >= M || nY >= N) {
                    continue;
                }

                if(visited[nX][nY]){
                    continue;
                }

                visited[nX][nY] = true;

                if(boardCopy[nX][nY] == 'O') {
                    if(nX == 0 || nY == 0 || nX == M-1 || nY == N-1){
                        return;
                    }else {
                        list.add(new int[]{nX, nY});
                        queue.add(new int[]{nX, nY});
                    }
                }
            }
        }

        for (int[] ints : list) {
            boardCopy[ints[0]][ints[1]] = 'X';
        }

    }
}
