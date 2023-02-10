//욕심쟁이 판다
//dfs로 전부 돌았는데.. 시간초과난다.
//dfs + dp로 풀어야했떤 문제.
package exercise_coding.backjun.backjun20230213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam01 {
    static int[][] dirs = {{1,0}, {-1,0} , {0,1} , {0,-1}};
    static int[][] forest;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        forest = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, dfs(i,j));
            }
        }
        System.out.println(Arrays.deepToString(visited));
        System.out.println(answer);
    }

    private static int dfs(int x, int y) {
        if(visited[x][y] != 0){
            return visited[x][y];
        }

        visited[x][y] = 1;

        for(int[] dir : dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];

            if(nx < 0 || ny < 0 || nx >= forest.length || ny >= forest.length){
                continue;
            }

            if(forest[x][y] >= forest[nx][ny]){
                continue;
            }

            visited[x][y] = Math.max(visited[x][y] , dfs(nx,ny) + 1);
        }
        return visited[x][y];
    }
}
