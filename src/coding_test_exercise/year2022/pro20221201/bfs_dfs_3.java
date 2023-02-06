package coding_test_exercise.year2022.pro20221201;

import java.util.LinkedList;
import java.util.Queue;

public class bfs_dfs_3 {

    static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
//        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int[][] visited = new int[maps.length][maps[0].length];
        bfs(maps,visited);
        return visited[maps.length-1][maps[0].length-1] == 0 ? -1 : visited[maps.length-1][maps[0].length-1];
    }

    public static void bfs(int[][] maps , int[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visited[0][0] = 1;
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int[] dir : dirs) {
                int xNext = x + dir[0];
                int yNext = y + dir[1];

                if(xNext < 0 || yNext < 0 || xNext >= maps.length || yNext >= maps[xNext].length || visited[xNext][yNext] == 1){
                    continue;
                }

                if(maps[xNext][yNext] == 1 && visited[xNext][yNext] == 0){
                    visited[xNext][yNext] = visited[x][y] + 1;
                    queue.add(new int[]{xNext,yNext});
                }
            }
        }
    }
}
