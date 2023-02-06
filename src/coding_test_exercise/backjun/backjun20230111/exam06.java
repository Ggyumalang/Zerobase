package coding_test_exercise.backjun.backjun20230111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam06 {
    static class Point {
        int x;
        int y;
        int cnt; //벽을 부순 갯수

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int N,M;
    final static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N+1][M+1];
        //초기화
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 1; j <= M; j++) {
                board[i][j] = str.charAt(j-1) - '0';
            }
        }

        int answer = bfs(1,1);
        System.out.println(answer);

    }

    private static int bfs(int x, int y) {
        PriorityQueue<Point> queue = new PriorityQueue<>((p1,p2) -> p1.cnt - p2.cnt);
        queue.add(new Point(x,y,0));
        boolean[][] visited = new boolean[N+1][M+1];
        visited[x][y] = true;

        while (!queue.isEmpty()){
            Point cur = queue.poll();
            int px = cur.x;
            int py = cur.y;

            if(px == N && py == M){
                return cur.cnt;
            }

            for(int[] dir : dirs){
                int nx = px + dir[0];
                int ny = py + dir[1];

                if(nx <= 0 || ny <= 0 || nx >= board.length || ny >= board[x].length){
                    continue;
                }

                if(visited[nx][ny]){
                    continue;
                }
                visited[nx][ny] = true;

                if(board[nx][ny] == 0){
                    queue.offer(new Point(nx,ny,cur.cnt));
                }else {
                    queue.offer(new Point(nx,ny,cur.cnt+1));
                }
            }
        }
        return 0;
    }
}
