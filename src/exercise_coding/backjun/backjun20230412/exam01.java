package exercise_coding.backjun.backjun20230412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam01 {

    final static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, M;
    static int[][] lab;
    static List<int[]> viruses;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];
        viruses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < viruses.size(); i++) {
            System.out.println("viruses = " + Arrays.toString(viruses.get(i)));
        }

        dfs(0);
        System.out.println("count = " + count);
    }

    private static void dfs(int cnt) {

        if (cnt == 3) {
            System.out.println("lab = " + Arrays.deepToString(lab));
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    dfs(cnt + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    private static void spreadVirus() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] labCopy = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(lab[i], 0, labCopy[i], 0, M);
        }
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < viruses.size(); i++) {
            queue.add(viruses.get(i));
            visited[viruses.get(i)[0]][viruses.get(i)[1]] = true;
        }

        while (!queue.isEmpty()) {
            int[] virus = queue.poll();
            int x = virus[0], y = virus[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || nx >= labCopy.length || ny < 0
                    || ny >= labCopy[0].length) {
                    continue;
                }

                if (labCopy[nx][ny] == 0) {
                    labCopy[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        System.out.println("labCopy = " + Arrays.deepToString(labCopy));
        checkSafeArea(labCopy);

    }

    private static void checkSafeArea(int[][] labCopy) {
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (labCopy[i][j] == 0) {
                    safe++;
                }
            }
        }

        count = Math.max(count, safe);
    }


}
