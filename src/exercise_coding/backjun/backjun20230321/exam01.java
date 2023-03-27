//백준 - 연구소3
//메모리 초과.
package exercise_coding.backjun.backjun20230321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class exam01 {
    static int[][] labCopy;
    static int answer;

    static class Virus {
        int idx;
        int x;
        int y;

        public Virus(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Virus{" +
                    "idx=" + idx +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    final static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] lab = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        labCopy = lab;

        answer = Integer.MAX_VALUE;
        List<Virus> viruses = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lab[i][j] == 2) {
                    viruses.add(new Virus(idx, i, j));
                }
            }
        }
        boolean[] visited = new boolean[viruses.size()];
        combination(viruses, lab, visited, 0 , viruses.size(), M);
        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
    }

    static void combination(List<Virus> viruses, int[][] lab, boolean[] visited, int depth, int n, int r) {

        if (r == 0) {
            int[][] checked = new int[lab.length][lab.length];
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    bfs(viruses.get(i), checked);
                }
            }
            if(isChecked(checked)){
                answer = Math.min(answer, Arrays.stream(checked).flatMapToInt(IntStream::of).max().getAsInt());
            }
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        combination(viruses, lab , visited, depth + 1, n, r - 1);
        visited[depth] = false;
        combination(viruses, lab , visited, depth + 1, n, r);
    }

    private static boolean isChecked(int[][] checked) {
        for (int i = 0; i < checked.length; i++) {
            for (int j = 0; j < checked.length; j++) {
                if(labCopy[i][j] == 0 && checked[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    private static void bfs(Virus virus, int[][] checked) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{virus.x, virus.y, 0});
        int maxCnt = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0] , y = cur[1] , cnt = cur[2];

            if(checked[x][y] > 0){
                checked[x][y] = Math.min(checked[x][y], cnt);
            }else {
                checked[x][y] = cnt;
            }

            for(int[] dir : dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx < 0 || ny < 0 || nx >= labCopy.length || ny >= labCopy.length){
                    continue;
                }

                if(labCopy[nx][ny] != 0){
                    continue;
                }

                if(checked[nx][ny] != 0 && checked[nx][ny] < cnt){
                    continue;
                }

                queue.offer(new int[]{nx,ny,cnt+1});
            }
        }
    }


}
