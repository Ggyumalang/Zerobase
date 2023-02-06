//백준 1261번 알고스팟
package coding_test_exercise.backjun.backjun20230111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam06_1 {
    static class Point {
        int x;
        int y;
        int breakCnt;

        public Point(int x, int y, int breakCnt) {
            this.x = x;
            this.y = y;
            this.breakCnt = breakCnt;
        }
    }

    static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        board = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        //초기화
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = str.charAt(j - 1) - '0';
            }
        }

        System.out.println(bfs(1, 1));
    }

    public static int bfs(int x, int y) {
        //가장 벽이 최소인 것부터 찾아서 들어간다.
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> p1.breakCnt - p2.breakCnt);
        pq.offer(new Point(x, y, 0));
        visited[x][y] = true;

        while (!pq.isEmpty()) {
            Point cur = pq.poll();

            if (cur.x == board.length - 1 && cur.y == board[0].length - 1) {
                return cur.breakCnt;
            }

            for (int[] dir : dirs) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];

                if (nx < 1 || ny < 1 || nx >= board.length || ny >= board[0].length) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                if (board[nx][ny] == 1) {
                    pq.offer(new Point(nx, ny, cur.breakCnt + 1));
                } else {
                    pq.offer(new Point(nx, ny, cur.breakCnt));
                }

            }
        }
        return 0;
    }
}
