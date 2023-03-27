//백준 - 로봇청소기

package exercise_coding.backjun.backjun20230327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam02 {

    static class Robot{
        int x;
        int y;

        public Robot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    final static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] room;
    static int clean,N,M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        room = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean = 1;
        bfs(x,y,dir);
        System.out.println(clean);
    }

    private static void bfs(int x, int y, int direction) {
        Queue<Robot> queue = new LinkedList<>();
        queue.add(new Robot(x,y));
        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int[] dir = dirs[(direction+i) % 4];
            queue.add(new Robot(x,y));
            while (!queue.isEmpty()){
                Robot robot = queue.poll();

                int nx = robot.x + dir[0];
                int ny = robot.y + dir[1];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M ){
                    continue;
                }

                if(visited[nx][ny] || room[nx][ny] == 1){
                    continue;
                }

                if(room[nx][ny] == 0){
                    clean++;
                }

                visited[nx][ny] = true;
                queue.offer(new Robot(nx,ny));
                x = nx;
                y = ny;
            }
        }

    }
}
