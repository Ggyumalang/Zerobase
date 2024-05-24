//909. Snakes and Ladders
package exercise_coding.leetcode.leet20240521;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public static void main(String[] args) {
        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        System.out.println(snakesAndLadders(board));

        board = new int[][]{{-1,-1},{-1,3}};
        System.out.println(snakesAndLadders(board));

        board = new int[][]{{-1,-1,-1},{-1,9,8},{-1,8,9}};
        System.out.println(snakesAndLadders(board));

        board = new int[][]{{-1,7,-1},{-1,6,9},{-1,-1,2}};
        System.out.println(snakesAndLadders(board));

        board = new int[][]{{-1,1,2,-1},{2,13,15,-1},{-1,10,-1,-1}, {-1,6,2,8}};
        System.out.println(snakesAndLadders(board));

        board = new int[][]{{1,1,-1},{1,1,1},{-1,1,1}};
        System.out.println(snakesAndLadders(board));
    }

    static int answerVal;

    public static int snakesAndLadders(int[][] board) {
        answerVal = -1;
        bfs(board);
        return answerVal;
    }

    private static void bfs(int[][] board) {
        int n = board.length;
        int target = n * n;
        boolean[] visited = new boolean[target + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); // [current cell, moves]

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currCell = curr[0];
            int moves = curr[1];

            System.out.println("currCell >>> " + currCell);
            System.out.println("moves >>> " + moves);

            if (currCell == target) {
                answerVal = moves;
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int nextCell = currCell + i;
                if (nextCell > target) break;

                int[] pos = getPosition(nextCell, n);
                int r = pos[0];
                int c = pos[1];

                if (board[r][c] != -1) {
                    nextCell = board[r][c];
//                    int[] newPos = getPosition(nextCell, n);
//                    int nr = newPos[0];
//                    int nc = newPos[1];
//
//                    if(board[nr][nc] != -1) {
//                        visited[nextCell] = true;
//                        continue;
//                    }
                }

                if (!visited[nextCell]) {
                    visited[nextCell] = true;
                    queue.offer(new int[]{nextCell, moves + 1});
                }
            }
        }
    }

    private static int[] getPosition(int cell, int n) {
        int row = (cell - 1) / n;
        int col = (cell - 1) % n;
        if (row % 2 == 1) {
            col = n - 1 - col;
        }
        row = n - 1 - row;
        return new int[]{row, col};
    }
}
