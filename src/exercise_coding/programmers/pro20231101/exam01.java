//bfs
//프로그래머스 - 게임 맵 최단거리
package exercise_coding.programmers.pro20231101;

import java.util.LinkedList;
import java.util.Queue;

public class exam01 {

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }

    public final static int[][] dirs = {{1,0}, {-1,0},{0,1},{0,-1}};
    public static int solution(int[][] maps) {
        return bfs(maps);
    }

    private static int bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int xLen = maps.length;
        int yLen = maps[0].length;
        int[][] visited = new int[xLen][yLen];
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0] , y = cur[1];

            if(x == xLen - 1 && y == yLen - 1) {
                return visited[x][y];
            }

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx < 0 || ny < 0 || nx >= xLen || ny >= yLen) {
                    continue;
                }

                if(visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        return -1;
    }
}
