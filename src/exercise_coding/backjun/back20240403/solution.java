//백준 - 미로탐색(2178번) 실버 1
package exercise_coding.backjun.back20240403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class solution {

    final static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int n;
    static int m;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String num = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Character.getNumericValue(num.charAt(j - 1));
            }
        }

        bfs(arr);
        System.out.println(answer);
    }

    private static void bfs(int[][] arr) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n + 1][m + 1];

        queue.add(new int[]{1, 1, 1});
        visited[1][1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            if (x == n && y == m) {
                answer = cnt;
                return;
            }

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx <= 0 || ny <= 0 || nx > n || ny > m) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (arr[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny, cnt + 1});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
