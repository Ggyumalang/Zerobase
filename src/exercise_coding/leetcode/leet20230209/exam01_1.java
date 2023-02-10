//leetCode 1162. As Far from Land as Possible
//풀이보고..
package exercise_coding.leetcode.leet20230209;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class exam01_1 {
    public static void main(String[] args) {    
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        System.out.println("maxDistance(grid) = " + maxDistance(grid));
    }
    final static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] gridCopy;
    public static int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int water = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0){
                    water++;
                }else {
                    q.offer(new int[]{i,j});
                }
            }
        }

        if(water == 0 || water == m * n){
            return -1;
        }

        int ans = 0;

        for (int d = 0; !q.isEmpty(); ++d) {
            for(int sz = q.size(); sz > 0 ; sz--){
                int[] cur = q.poll();
                int i = cur[0] , j = cur[1];
                ans = d;
                for (int[] dir : dirs) {
                    int nI = i + dir[0];
                    int nJ = j + dir[1];

                    if( nI < 0 || nI >= m || nJ < 0 || nJ >= n){
                        continue;
                    }

                    if(grid[nI][nJ] > 0) {
                        continue;
                    }

                    q.offer(new int[]{nI, nJ});
                    grid[nI][nJ] = 2; //Mark as visited
                }
            }
        }
        return ans;
    }

    public static int getDistance(int[] pos1 , int[] pos2){
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
}
