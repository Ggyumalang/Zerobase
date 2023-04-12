//백준 2573 - 빙산
package exercise_coding.backjun.backjun20230412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class exam02 {

    static int N, M;
    static int[][] earth;
    static List<int[]> ices;
    static List<int[]> removeList;
    final static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        earth = new int[N][M];
        ices = new ArrayList<>();
        removeList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                earth[i][j] = Integer.parseInt(st.nextToken());
                if (earth[i][j] != 0) {
                    ices.add(new int[]{i, j});
                }
            }
        }

        int count = 0;

        while (isConnected() && ices.size() > 0) {
            count++;
            for (int[] ice : ices) {
                decreaseHeight(ice);
            }
            minusToZero();
            System.out.println("earth = " + Arrays.deepToString(earth));
            ices.removeAll(removeList);
            removeList.clear();
        }
        System.out.println("count = " + count);
    }

    private static void minusToZero() {
        for (int[] ints : removeList) {
            earth[ints[0]][ints[1]] = 0;
        }
    }

    private static boolean isConnected() {
        boolean[][] visited = new boolean[N][M];
        visited[ices.get(0)[0]][ices.get(0)[1]] = true;
        dfs(visited, ices.get(0));
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt == ices.size();
    }

    private static void dfs(boolean[][] visited, int[] ice) {
        for (int[] dir : dirs) {
            int nx = ice[0] + dir[0];
            int ny = ice[1] + dir[1];

            if (nx < 0 || nx >= earth.length || ny < 0
                || ny >= earth[0].length) {
                continue;
            }

            if (visited[nx][ny]) {
                continue;
            }

            if (earth[nx][ny] != 0) {
                visited[nx][ny] = true;
                dfs(visited, new int[]{nx, ny});
            }
        }
    }

    private static void decreaseHeight(int[] ints) {

        for (int[] dir : dirs) {
            int nx = ints[0] + dir[0];
            int ny = ints[1] + dir[1];

            if (nx < 0 || nx >= earth.length || ny < 0
                || ny >= earth[0].length) {
                continue;
            }

            if (earth[nx][ny] == 0) {
                earth[ints[0]][ints[1]]--;
                if (earth[ints[0]][ints[1]] == 0) {
                    earth[ints[0]][ints[1]] = -1;
                    removeList.add(ints);
                }
            }
        }
    }
}
