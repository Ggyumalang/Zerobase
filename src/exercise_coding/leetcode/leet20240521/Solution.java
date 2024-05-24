//909. Snakes and Ladders
package exercise_coding.leetcode.leet20240521;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        System.out.println(snakesAndLadders(board));

        board = new int[][]{{-1,-1},{-1,3}};
        System.out.println(snakesAndLadders(board));

        board = new int[][]{{-1,-1,-1},{-1,9,8},{-1,8,9}};
        System.out.println(snakesAndLadders(board));
    }

    static int answerVal;
    static int[][] dirs;
    public static int snakesAndLadders(int[][] board) {
        bfs(board , board.length-1, 0);
        return answerVal;
    }

    private static void bfs(int[][] board, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col, 0,  0}); //사다리나 뱀 아무것도 타지 않고 있음.
        int length = board.length;
        int n2 = (length * length);
        boolean isEdge = false;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int val = cur[2];
            int answer = cur[3];

            if(val == n2) {
                answerVal = answer + 1;
                return;
            }

            for (int i = val + 1; i <= Math.min(val + 6, n2); i++) {
                int share = i / length;
                int direction = share % 2;
                int remain = i % length;
                int nr = length - share - 1;
                int nc = remain - 1;
                if(remain == 0) {
                    if(direction == 1) {
                      nc = length - 1;
                    } else {
                      nc = 0;
                    }
                    nr++;
                }

                if( i == n2 ) {
                    answerVal = answer + 1;
                    return;
                }

                if(board[nr][nc] == -1) {
                    queue.offer(new int[]{nr,nc, 0, i, answer + 1});
                } else {
                    int boardVal = board[nr][nc];
                    share = boardVal / length;
                    remain = boardVal % length;
                    direction = share % 2;
                    nr = length - 1 - share;
                    nc = remain - 1;

                    if(remain == 0) {
                        if(direction == 1) {
                            nc = length - 1;
                        } else {
                            nc = 0;
                        }
                        nr++;
                    }

                    if(boardVal == n2) {
                        answerVal = answer + 1;
                        return;
                    }

                    if(board[nr][nc] != -1) {
                        continue;
                    }
                    queue.offer(new int[]{nr,nc,0, boardVal, answer + 1});
                }
            }
        }
    }

    private static void offerQueue(Queue<int[]> queue, int[][] nums, int inRide, int val, int direction) {
        if(inRide == 1) {
            return;
        }
        int[] newPos = getPos(nums, val);

        queue.offer(new int[]{newPos[0],newPos[1], 1, direction});
    }

    private static int[] getPos(int[][] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[i][j] == val) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
